import org.antlr.v4.runtime.*;
import org.antlr.v4.gui.TestRig;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.tool.Rule;

import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.*;

public class Listener extends TinyLangBaseListener{

    //l objet table pour pouvoir ajouter dans la ts
    private TS table = new TS();
    public int nbErreurs;

    //table de hashage pour pouvoir range le type et la regle
    private HashMap<ParserRuleContext,String> Ruletype = new HashMap<>();
    private Stack<String> pfExpression = new Stack<>();
    private Stack<String> optStack = new Stack<>();

    LinkedList<String> erreurs = new LinkedList<>();

    @Override
    public void exitProgramme(TinyLangParser.ProgrammeContext ctx) {
        this.nbErreurs = this.erreurs.size();
        if (this.nbErreurs == 0){
            //Aucune erreur dans le programme
            System.out.println("\n\033[0;97mLa table des symboles");
            this.table.afficheTS();

        } else {
            // Dans le cas où il y a des erreurs
            System.out.print("\n");
            System.out.println("\t\033[0;97mListe des erreurs ");
            System.out.println("-------------------------\n");
            for ( String error: this.erreurs ) {
                System.out.println(error);
            }
        }
    }

    @Override
    public void exitDeclaration(TinyLangParser.DeclarationContext ctx) {
        TinyLangParser.TypeContext typeVar = ctx.type();
        TinyLangParser.IdentifiantsContext varsCtx = ctx.identifiants();
        String vars[] = varsCtx.getText().split(",");
        for ( String v : vars) {
            //instanciation d'un element
            TS.Element element = new TS.Element(v, typeVar.getText(), null, 1);

            //Ajout à la table des symboles
            if (!table.containsElement(v)){
                table.addElement(element);
            }else{
                this.addError("Erreur: double déclaration de la variable \033[0;94m" + v +"\t\033[0;97m");
            }
        }
    }

    @Override
    public void exitAffectation(TinyLangParser.AffectationContext ctx) {
        if (ctx.IDENTIFIANT() != null){
            if (declared(ctx.IDENTIFIANT().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine())) {
                //dans le cas ou la variable et declarer on verifie le type de l'idf et la variable affecter
                //on recuperer le type de la variable de la table de hachage Ruletype
                if (!(table.getElement(ctx.IDENTIFIANT().getText()).type).equals(Ruletype.get(ctx.expressionArithmetique()))) {
                    this.addError("Erreur [ligne " + ctx.start.getLine() + ", colonne " + ctx.start.getCharPositionInLine() + "]: Incompatibilité des types de la variable [\033[0;94m "+table.getElement(ctx.IDENTIFIANT().getText())+ "\033[0;97m] et la variable \033[0;94m "+ctx.expressionArithmetique().getText()+"\033[0;97m type : \033[0;94m"+Ruletype.get(ctx.expressionArithmetique()) + "\033[0;97m");
                }
            }
        }
    }


    @Override
    public void exitExpressionArithmetique(TinyLangParser.ExpressionArithmetiqueContext ctx) {
        if(ctx.IDENTIFIANT() != null) {
            if (declared(ctx.IDENTIFIANT().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine())) {
                this.checkExprType(ctx, this.table.getElement(ctx.IDENTIFIANT().getText()).type);
            }
        }
        if (ctx.INT() != null){
            this.checkExprType(ctx, "intCompil");
        }
        if (ctx.CNST() != null){
            this.optStack.push(ctx.CNST().getText());
            this.checkExprType(ctx, "intCompil");
        }

        if(ctx.FLOAT() != null){
            this.checkExprType(ctx, "floatCompil");
        }

        if (ctx.opt() != null){
            if (!this.optStack.empty())
                if(ctx.opt().getText().equals("/") && this.optStack.peek().equals("0")){
                    this.addError("Erreur [ligne " + ctx.start.getLine() + " , colonne " + ctx.start.getCharPositionInLine() + "]: Division par \t\033[0;94m 0. \033[0;97m");
                    this.optStack.clear();
                }

        }

        if (!(ctx.getParent() instanceof TinyLangParser.ExpressionArithmetiqueContext)){
            if(!this.pfExpression.empty()){
                String exprType = this.pfExpression.pop();
                this.Ruletype.put(ctx, exprType);
                this.pfExpression.clear();
            }
        }
    }

    @Override
    public void exitExpressionLogique(TinyLangParser.ExpressionLogiqueContext ctx) {
        if (ctx.getChild(0) != null && ctx.getChild(2) != null){
            String type1 = this.Ruletype.get(ctx.getChild(0));
            String type2 = this.Ruletype.get(ctx.getChild(2));
            if (!(type1.equals(type2))){
                this.addError("Erreur [ligne " + ctx.start.getLine() + ", colonne " + ctx.start.getCharPositionInLine() + "]: Incompatibilité de type dans l'expression ( \033[0;94m" + type1 + " \033[0;97m et \033[0;94m" + type2 + "\033[0;97m )");
            }
        }
    }

    @Override
    public void exitIdentifiants(TinyLangParser.IdentifiantsContext ctx) {
        ParserRuleContext p = ctx.getParent();
        if(p instanceof TinyLangParser.Print_valContext || p instanceof TinyLangParser.ScanContext){
            if (ctx.IDENTIFIANT() != null)
                declared(ctx.IDENTIFIANT().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
    }


    private void checkExprType(ParserRuleContext ctx, String type){
        if (!this.pfExpression.empty()) {
            String registredType = this.pfExpression.pop();
            if (type.equals(registredType)) {
                this.pfExpression.push(type);
                this.Ruletype.put(ctx, type);
            } else {
                this.addError("Erreur [ligne " + ctx.start.getLine() + ", colonne " + ctx.start.getCharPositionInLine() + "]: Incompatibilité de type dans l'expression ( \033[0;94m" + type + " \033[0;97m et \033[0;94m" + registredType + "\033[0;97m)");
            }
        } else {
            this.pfExpression.push(type);
        }
    }

    public LinkedList<String> getErreurs(){
        return this.erreurs;
    }

    //Ajouter une erreur à la liste si elle n'existe pas
    private void addError(String error){
        if (!this.erreurs.contains(error)){
            this.erreurs.add(error);
        }
    }


    private boolean declared(String v, int line, int column){
        if(!this.table.containsElement(v)){
            String error = "Erreur [ligne " + line + ", colonne " + column + "]: Variable \033[0;94m" + v + "\033[0;97m non déclarée";
            this.addError(error);
            return false;
        }
        return true;
    }

}
