import org.antlr.v4.runtime.*;
import org.antlr.v4.gui.TestRig;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.tool.Rule;

import javax.print.DocFlavor;
import java.util.*;

public class Listener extends TinyLangBaseListener{

    public class Rule{
        private final String type;
        private final String value;

        public String getValue() {
            return value;
        }

        public Rule(String type, String val){
            this.type = type;
            this.value = val;
        }

        public String getType() {
            return type;
        }
    }

    //l objet table pour pouvoir ajouter dans la ts
    private final TS table = new TS();
    public int nbErreurs;

    //table de hashage pour pouvoir range le type et la regle
    private HashMap<ParserRuleContext,Rule> Ruletype = new HashMap<>();
    private Stack<String> pfExpression = new Stack<>();

    LinkedList<String> erreurs = new LinkedList<>();

    @Override
    public void exitProgramme(TinyLangParser.ProgrammeContext ctx) {
        this.nbErreurs = this.erreurs.size();
        if (this.nbErreurs == 0){
            //Aucune erreur dans le programme
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
                this.addError("Erreur: double déclaration de la variable " + v);
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
                    this.addError("Erreur [ligne " + ctx.start.getLine() + ", colonne " + ctx.start.getCharPositionInLine() + "]: Incompatibilité des types de la variable ["+table.getElement(ctx.IDENTIFIANT().getText())+ "] et la variable "+ctx.expressionArithmetique().getText()+" type :"+Ruletype.get(ctx.expressionArithmetique()));
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
            if (declared(ctx.IDENTIFIANT().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine())) {
                this.checkExprType(ctx, this.table.getElement(ctx.IDENTIFIANT().getText()).type);
            }
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
                this.addError("Erreur [ligne " + ctx.start.getLine() + ", colonne " + ctx.start.getCharPositionInLine() + "]: Incompatibilité de type dans l'expression ( " + type + " et " + registredType + " )");
            }
        } else {
            this.pfExpression.push(type);
        }
    }

    private void checkInit(ParserRuleContext ctx, String id){
        if (this.table.getElement(id).value == null){
            this.addError("Erreur [ligne " + ctx.start.getLine() + ", colonne " + ctx.start.getCharPositionInLine() + "]: Variable " + id + " non initialisée.");
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
            String error = "Erreur [ligne " + line + ", colonne " + column + "]: Variable " + v + " non déclarée";
            this.addError(error);
            return false;
        }
        return true;
    }

}
