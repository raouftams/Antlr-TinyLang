import org.antlr.v4.runtime.*;
import org.antlr.v4.gui.TestRig;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.tool.Rule;

import javax.print.DocFlavor;
import java.util.*;

public class Listener extends TinyLangBaseListener{
    //l objet table pour pouvoir ajouter dans la ts
    private TS table = new TS();
    public int nbErreurs;

    //table de hashage pour pouvoir range le type et la regle
    private HashMap<ParserRuleContext,String> Ruletype = new HashMap<>();
    private Stack<String> pfExpression = new Stack<>();

    LinkedList<String> erreurs = new LinkedList<>();
    //elle nous permet de parcourir l'arbre et a chaque regle on fait un traitement
    //ajout dans la ts par exemple
    //exitdv parceque je doit recuperer le type 0 si float et 1  sinon


    @Override
    public void exitProgramme(TinyLangParser.ProgrammeContext ctx) {
        if (this.erreurs.size() == 0){
            //Aucune erreur dans le programme
            this.nbErreurs = 0;
            System.out.println("\nLa table des symboles");
            this.table.afficheTS();

        } else {
            // Dans le cas où il y a des erreurs
            System.out.print("\n");
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
                this.erreurs.add("Erreur: double déclaration de la variable " + v);
            }
        }
    }

    @Override
    public void exitAffectation(TinyLangParser.AffectationContext ctx) {
        if (ctx.IDENTIFIANT() != null){
            if (!table.containsElement(ctx.IDENTIFIANT().getText())){
                this.erreurs.add("Erreur: la variable " + ctx.IDENTIFIANT().getText() + "  n'est pas declarée");
            }
            else{
                //dans le cas ou la variable et declarer on verifie le type de l'idf et la variable affecter
                //on recuperer le type de la variable de la table de hachage Ruletype
                if (!(table.getElement(ctx.IDENTIFIANT().getText()).type).equals(Ruletype.get(ctx.expressionArithmetique()))) {
                    this.erreurs.add("Erreur: Incompatibilité des types de la variable ["+table.getElement(ctx.IDENTIFIANT().getText())+ "] et la variable "+ctx.expressionArithmetique().getText()+" type :"+Ruletype.get(ctx.expressionArithmetique()));
                }
            }
        }
    }


    @Override
    public void exitExpressionArithmetique(TinyLangParser.ExpressionArithmetiqueContext ctx) {
        if(ctx.IDENTIFIANT() != null) {
            if (!table.containsElement(ctx.IDENTIFIANT().getText())) {
                this.erreurs.add("Erreur: la variable " + ctx.IDENTIFIANT().getText() + "n'est pas declaree");
            } else {
                this.checkExprType(ctx, this.table.getElement(ctx.IDENTIFIANT().getText()).type);
            }
        }
        if (ctx.INT() != null || ctx.CNST() != null){
            this.checkExprType(ctx, "intCompil");
        }
        if(ctx.FLOAT() != null){
            this.checkExprType(ctx, "floatCompil");
        }

        if (ctx.getParent().getChild(1).getText().equals("=")){
            if(!this.pfExpression.empty()){
                String exprType = this.pfExpression.pop();
                this.Ruletype.put(ctx, exprType);
                this.pfExpression.clear();
            }
        }
    }

    @Override
    public void exitExpressionLogique(TinyLangParser.ExpressionLogiqueContext ctx) {
        if(ctx.IDENTIFIANT() != null) {
            this.checkExprType(ctx, this.table.getElement(ctx.IDENTIFIANT().getText()).type);
        }
        if (ctx.STRING() != null ){
                this.checkExprType(ctx, "stringCompil");
            }
        if(ctx.INT() != null){
                this.checkExprType(ctx, "intCompil");
            }
        if(ctx.FLOAT() != null ){
                this.checkExprType(ctx, "floatCompil");
            }

        if (ctx.getParent().getChild(0).getText().equals("if") || ctx.getParent().getChild(0).getText().equals("do")){
            if(!this.pfExpression.empty()){
                this.pfExpression.clear();
            }
        }
    }

    private void checkExprType(ParserRuleContext ctx, String type){
        if (!this.pfExpression.empty()) {
            String registredType = this.pfExpression.pop();
            if (type.equals(registredType)) {
                this.pfExpression.push(type);
                this.Ruletype.put(ctx, type);
            } else {
                this.erreurs.add("Erreur, ligne " + ctx.start.getLine() + ": Incompatibilité de type dans l'expression ( " + type + " et " + registredType + " )");
            }
        } else {
            this.pfExpression.push(type);
        }
    }

}
