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
        System.out.println("\n ctx \t Type ");
        System.out.println("--------------------------------------");
        for (Map.Entry<ParserRuleContext, String> entry: this.Ruletype.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
            System.out.println("--------------------------------------");
        }
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
                this.erreurs.add("Erreur: la variable " + ctx.IDENTIFIANT().getText() + " n'est pas declaree");
            }
            else{
                //dans le cas ou la variable et declarer on verifie le type de l'idf et la variable affecter
                //on recuperer le type de la variable de la table de hachage Ruletype
                System.out.println(this.Ruletype.get(ctx.expressionArithmetique()));
                if ((table.getElement(ctx.IDENTIFIANT().getText()).type).equals (Ruletype.get(ctx.expressionArithmetique()))) {
                    this.erreurs.add("Incompatibilité des types de la variable "+table.getElement(ctx.IDENTIFIANT().getText())+ " et la variable "+ctx.expressionArithmetique().getText()+" type :"+Ruletype.get(ctx.expressionArithmetique()));
                }
            }
        }
    }


    @Override
    public void exitExpressionArithmetique(TinyLangParser.ExpressionArithmetiqueContext ctx) {
        if(ctx.IDENTIFIANT() != null){
            if(!table.containsElement(ctx.IDENTIFIANT().getText())) {
                this.erreurs.add("Erreur: la variable " + ctx.IDENTIFIANT().getText() + "n'est pas declaree");
            } else{
                if (!this.pfExpression.empty()){
                    String type = this.pfExpression.pop();
                    if (type.equals(this.table.getElement(ctx.IDENTIFIANT().getText()).type)){
                        this.pfExpression.push(type);
                        this.Ruletype.put(ctx, type);
                    }else{
                        this.erreurs.add("Incompatibilité de type dans l'expression, ligne: " + ctx.start.getLine());
                    }
                }else{
                    this.pfExpression.push(this.table.getElement(ctx.IDENTIFIANT().getText()).type);
                }
            }

        }
    }
}
