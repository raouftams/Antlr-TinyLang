
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class GenerateurQuad extends TinyLangBaseListener{

    private LinkedList<String> postStack = new LinkedList<>();
    private HashMap<ParserRuleContext, String> ruleTemp = new HashMap<>();
    public ListQuad quads = new ListQuad();
    private int cptTemps = 0;
    private int i = 0;
    private LinkedList<String> tStack = new LinkedList<String>();
    private LinkedList<String> rStack = new LinkedList<String>();
    private Stack<Integer> conditionsQuads = new Stack<Integer>();
    private Listener listener;

    public GenerateurQuad(Listener listener) {
        this.listener = listener;
    }


    @Override public void exitProgramme(TinyLangParser.ProgrammeContext ctx)
    {
        if(listener.getErreurs().size()>0)
            return;
        quads.addQuad("END","","","");
        this.quads.afficherQuad();
    }

    @Override public void exitAffectation(TinyLangParser.AffectationContext ctx)
    {
        quads.addQuad("=",this.ruleTemp.get(ctx.expressionArithmetique()),"",ctx.IDENTIFIANT().getText());
    }


    @Override public void exitExpressionLogique(TinyLangParser.ExpressionLogiqueContext ctx) {
        String temp1 = this.ruleTemp.get(ctx.getChild(0));
        String temp2 = this.ruleTemp.get(ctx.getChild(2));
        String opt = "";
        if (temp1.equals("0") || temp2.equals("0")){
            if (ctx.getParent() instanceof TinyLangParser.ConditionContext)
                opt = this.getEquivalentIf(ctx.opl().getText(), true);
            else opt = this.getEquivalentLoop(ctx.opl().getText(), true);

        }else{
            if(ctx.getParent() instanceof TinyLangParser.ConditionContext)
                opt = this.getEquivalentIf(ctx.opl().getText(), false);
            else opt = this.getEquivalentLoop(ctx.opl().getText(), false);
        }

        this.conditionsQuads.push(this.quads.addQuad(opt,"", temp1, temp2));

    }

    @Override public void exitExpressionArithmetique(TinyLangParser.ExpressionArithmetiqueContext ctx) {

        if (!(ctx.getParent() instanceof TinyLangParser.ExpressionArithmetiqueContext)){
            String exp = ctx.getText();
            this.expToQuads(ctx, this.infixToPostfix(exp));
        }
    }

    //Todo: Trouver où placer le branchement  >>sur le quad sur le quel faut se brancher à aprtir de enter ou exit ??
    //Todo: saveCondfin à la fin d'une expression du If

    int saveConditionEndif;
    @Override public void enterOptelse(TinyLangParser.OptelseContext ctx){

        if (!conditionsQuads.empty()){
            this.quads.getQuad(this.conditionsQuads.pop()).set(1, "AdrElse"+(this.quads.size()+2));
        }
        this.conditionsQuads.push(this.quads.addQuad("BR", "", "", ""));
    }

    @Override public void exitCondition(TinyLangParser.ConditionContext ctx)
    {
        if (!conditionsQuads.empty()) {
            this.quads.getQuad(this.conditionsQuads.pop()).set(1, "AdrEndIf" + (this.quads.size() + 1));
        }
    }

    int loop;
    @Override public void enterBoucle(TinyLangParser.BoucleContext ctx){
        loop = quads.size();
    }

    @Override public void exitBoucle(TinyLangParser.BoucleContext ctx){
        quads.getQuad(this.quads.size()-1).set(1,"AdrLoop"+(loop+1));
    }

    // priorité des opérateurs
    private int Prec(char ch) {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
                return 2;

            case '/':
                return 3;
        }
        return -1;
    }

    // Transformation de l'infixé au postfixé
    private String infixToPostfix(String exp) {
        String result = new String("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c))
                result += c;

            else if (c == '(')
                stack.push(c);
            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();


                    stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && Prec(c)
                        <= Prec(stack.peek())){

                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    //Transformation d'une expression postfixée en quadruplés
    private void expToQuads(ParserRuleContext ctx, String exp) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        if (exp.length() == 1) {
            this.ruleTemp.put(ctx, exp);
        } else{
            for (int i = 0; i < exp.length(); i++) {
                String c = "" + exp.charAt(i) + "";

                if (Character.isLetterOrDigit(exp.charAt(i)))
                    stack.push(c);
                else {
                    if (!stack.empty()) {
                        String val1 = stack.pop();
                        if (!stack.empty()) {
                            String val2 = stack.pop();
                            temp = "Temp" + (this.cptTemps++);
                            this.quads.addQuad(new Quad(c, val2, val1, temp));
                            stack.push(temp);
                        }
                    }
                }
            }
            this.ruleTemp.put(ctx, temp);
        }
    }

    //retourne le branchement d'un opérateur donné
    //zero est un boolean vérifiant si on compare avec 0
    private String getEquivalentIf(String opt, boolean zero){
        if (zero) {
            switch (opt) {
                case "!=":
                    return "BZ";
                case "<":
                    return "BG";
                case ">":
                    return "BL";
                default:
                    return "BNZ";
            }
        }else
            switch (opt) {
                case "<": return "BG";
                case ">": return "BL";
                case "!=": return "BE";
                default: return "BNE";
            }
    }

    private String getEquivalentLoop(String opt, boolean zero){
        if (zero) {
            switch (opt) {
                case "!=":
                    return "BNZ";
                case "<":
                    return "BL";
                case ">":
                    return "BG";
                default:
                    return "BZ";
            }
        }else
            switch (opt) {
                case "<": return "BL";
                case ">": return "BG";
                case "!=": return "BNE";
                default: return "BE";
            }
    }
}