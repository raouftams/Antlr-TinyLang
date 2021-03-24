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
    public int nberreur;
    //table de hashage pour pouvoir range le type et la regle
    private HashMap<ParserRuleContext,Integer> Ruletype = new HashMap<>();
    LinkedList<String> erreur = new LinkedList<>();
    //elle nous permet de parcourir l'arbre et a chaque regle on fait un traitement
    //ajout dans la ts par exemple
    //exitdv parceque je doit recuperer le type 0 si float et 1  sinon


    @Override
    public void enterAffectation(TinyLangParser.AffectationContext ctx) {
        super.enterAffectation(ctx);

    }

    @Override
    public void exitAffectation(TinyLangParser.AffectationContext ctx) {
        super.exitAffectation(ctx);
        ctx.getText();

            }
}
