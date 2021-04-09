import org.antlr.v4.runtime.ParserRuleContext;
import java.util.HashMap;
import java.util.LinkedList;

public class GenerateurQuad extends TinyLangBaseListener{

    private LinkedList<String> stack = new LinkedList<>();
    private ListQuad quads = new ListQuad();
    private int cptTemps = 0;
    Listener listener;

    public GenerateurQuad(Listener listener) {
        this.listener = listener;
    }


    @Override public void exitProgramme(TinyLangParser.ProgrammeContext ctx)
    {
        if(listener.getErreurs().size()>0)
            return;
        quads.addQuad("END","","","");
    }

    @Override public void exitAffectation(TinyLangParser.AffectationContext ctx)
    {
        quads.addQuad("=",ctx.getChild(2).getText(),"",ctx.getChild(0).getText());
    }

    int saveCondition;
    @Override public void exitExpressionLogique(TinyLangParser.ExpressionLogiqueContext ctx)
    {
        String Opl = switch (ctx.getChild(2).getText()) {
            case "<" -> "BL";
            case ">" -> "BG";
            case "==" -> "BE";
            case "!=" -> "BNE";
            default -> "BE";
        };
        saveCondition = quads.addQuad(Opl,ctx.getChild(1).getText(),ctx.getChild(2).getText(),"");
    }
    //todo: trouver si ctx.parent() donne le non terminale à l'origine de l'instru
    @Override public void exitExpressionArithmetique(TinyLangParser.ExpressionArithmetiqueContext ctx)
    {
        if(ctx.expressionArithmetique()!= null)//à revoire
        {
            String temp = "Temp"+(++cptTemps);
            quads.addQuad(ctx.opt().getText(),ctx.getChild(1).getText(),ctx.getChild(2).getText(),temp);
        }
    }

    //Todo: Trouver où placer le branchement  >>sur le quad sur le quel faut se brancher à aprtir de enter ou exit ??
    //Todo: saveCondfin à la fin d'une expression du If

    int saveConditionEndif;
    @Override public void enterOptelse(TinyLangParser.OptelseContext ctx){
        saveConditionEndif = quads.addQuad("BR","","","");//saut vers la fin du if si la condition retourne true
        quads.getQuad(saveCondition).set(1,""+quads.size());//sur le quad instruction de else dans le cas ou elles existent
    }

    @Override public void exitCondition(TinyLangParser.ConditionContext ctx)
    {
        if(ctx.optelse() == null) {
            quads.getQuad(saveCondition).set(1,""+quads.size()); //dans le cas ou il n'y a pas de Else
        }
        else {
            quads.getQuad(saveConditionEndif).set(3,""+quads.size());  //sur le quad suivant la fin du if si le else existe
        }
    }

    int loop;
    @Override public void enterBoucle(TinyLangParser.BoucleContext ctx){
        loop = quads.size();
    }

    @Override public void exitBoucle(TinyLangParser.BoucleContext ctx){
        quads.getQuad(quads.size() - 1).set(1,""+loop);
    }
}