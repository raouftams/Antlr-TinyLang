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
        String Opl="BE" ;
        switch(ctx.getChild(2).getText()) {
            case "<":
                Opl = "BL";
                break;
            case ">":
                Opl="BG";
                break;
            case "==":
                Opl="BE";
                break;
            case "!=":
                Opl="BNE";
                break;
        }
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
        saveConditionEndif = quads.addQuad("BR","","","");
        quads.getQuad(saveCondition).set(1,""+quads.size());//sur le quad else
    }

    @Override public void exitCondition(TinyLangParser.ConditionContext ctx)
    {
        quads.getQuad(saveConditionEndif).set(3,""+quads.size());//sur le quad suivant la fin du if
    }

/*
    @Override public void exitT(TinyLangParser.TContext ctx)
    {
        if(ctx.t() != null)
        {
            String t1 = stack.removeLast(),t2 = stack.removeLast();
            String temp = "Temp"+(++cptTemps);
            quads.addQuad(ctx.opma().getText(),t2,t1,temp);
            stack.add(temp);
            showText("exitT adding quad " + quads.getQuad(quads.size()-1),TextDisplayer.RANDOMCOMMENTS);
        }
        else
        {
            showText("exitT head of stack is: " + stack.getLast() + " stack size " + stack.size(),TextDisplayer.RANDOMCOMMENTS);
        }
    }

    @Override public void exitEndEx(TinyLangParser.EndExContext ctx)
    {
        if(ctx.exp() == null) {
            stack.add(ctx.getText());
            showText("exitEndEx: case exp == null adding "+ ctx.getText(),TextDisplayer.RANDOMCOMMENTS);
        }
        else
        {
            showText("exitEndEx: case exp = null adding nothing "+ stack.getLast(),TextDisplayer.RANDOMCOMMENTS);
        }
    }


    @Override public void exitEl(TinyLangParser.ElContext ctx)
    {
        quads.getQuad(saveCondition).set(3,""+(quads.size()+1));
        saveCondition = quads.addQuad("BR","","","");
    }

    @Override public void exitIfinst(TinyLangParser.IfinstContext ctx)
    {
        quads.getQuad(saveCondition).set(3,""+quads.size());
    }
*/
}