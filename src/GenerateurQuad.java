
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class GenerateurQuad extends TinyLangBaseListener{

    private LinkedList<String> postStack = new LinkedList<>();
    private HashMap<ParserRuleContext, String> ruleTemp = new HashMap<>();
    public ListQuad quads = new ListQuad();
    private Transform transform = new Transform();
    private int cptTemps = 0;
    private int i = 0;
    private LinkedList<String> tStack = new LinkedList<String>();
    private LinkedList<String> rStack = new LinkedList<String>();
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

    int saveCondition;
    @Override public void exitExpressionLogique(TinyLangParser.ExpressionLogiqueContext ctx) {


        /*
        String opl;
        switch (ctx.getChild(2).getText()) {
            case "<": opl = "BL";
            case ">": opl = "BG";
            case "==": opl = "BE";
            case "!=": opl = "BNE";
            default: opl = "BE";
        };
        saveCondition = quads.addQuad(opl,ctx.getChild(1).getText(),ctx.getChild(2).getText(),"");
        */
    }

    String operators = "+-*/";
    int j = 0;
    @Override public void exitExpressionArithmetique(TinyLangParser.ExpressionArithmetiqueContext ctx)
    {

        if (!(ctx.getParent() instanceof TinyLangParser.ExpressionArithmetiqueContext)){

            String exp = ctx.getText();
            this.expToQuads(ctx, this.infixToPostfix(exp));

        }
        /*

        if (!this.postStack.isEmpty()){
            String peek = this.postStack.peek();
            //Vérifier si tête de pile est un opérateur
            if(peek.equals("+") || peek.equals("-") || peek.equals("/") || peek.equals("*")){
                String opt = this.postStack.pop();
                String op1 = this.postStack.pop();
                String op2 = this.postStack.pop();
                String temp = "Temp"+(this.cptTemps++);
                this.quads.addQuad(opt, op2, op1, temp);
                this.postStack.push();
            }
        }
        if(ctx.IDENTIFIANT() != null){
            this.postStack.push(ctx.IDENTIFIANT().getText()));
        }

        if(ctx.expressionArithmetique()!= null)//à revoire
        {
            String temp = "Temp"+(++cptTemps);
            System.out.println("dagi");
            quads.addQuad(ctx.opt().getText(),ctx.getChild(1).getText(),ctx.getChild(2).getText(),temp);
        }

         */
    }

    //Todo: Trouver où placer le branchement  >>sur le quad sur le quel faut se brancher à aprtir de enter ou exit ??
    //Todo: saveCondfin à la fin d'une expression du If

    int saveConditionEndif;
    @Override public void enterOptelse(TinyLangParser.OptelseContext ctx){
       /* saveConditionEndif = quads.addQuad("BR","","","");//saut vers la fin du if si la condition retourne true
        quads.getQuad(saveCondition).set(1,""+quads.size());//sur le quad instruction de else dans le cas ou elles existent
    */
    }

    @Override public void exitCondition(TinyLangParser.ConditionContext ctx)
    {
        /*
        if(ctx.optelse() == null) {
            quads.getQuad(saveCondition).set(1,""+quads.size()); //dans le cas ou il n'y a pas de Else
        }
        else {
            quads.getQuad(saveConditionEndif).set(3,""+quads.size());  //sur le quad suivant la fin du if si le else existe
        }

         */
    }

    int loop;
    @Override public void enterBoucle(TinyLangParser.BoucleContext ctx){
        loop = quads.size();
    }

    @Override public void exitBoucle(TinyLangParser.BoucleContext ctx){
        //quads.getQuad(quads.size() - 1).set(1,""+loop);
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

}