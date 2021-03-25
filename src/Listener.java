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
    private HashMap<ParserRuleContext,Integer> Ruletype = new HashMap<>();

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
            if (table.containsElement(v) == false){
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
        }

    }
}
