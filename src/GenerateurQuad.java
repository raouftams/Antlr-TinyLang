import jdk.nashorn.internal.ir.WhileNode;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GenerateurQuad extends TinyLangBaseListener{

    private LinkedList<String> postStack = new LinkedList<>();
    public ListQuad quads = new ListQuad();
    private Transform transform = new Transform();
    private int cptTemps = 0;
    private int i = 0;
    private LinkedList<String> tStack = new LinkedList<String>();
    private LinkedList<String> rStack = new LinkedList<String>();
    Listener listener;

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
        quads.addQuad("=",ctx.getChild(2).getText(),"",ctx.getChild(0).getText());
    }

    int saveCondition;
    @Override public void exitExpressionLogique(TinyLangParser.ExpressionLogiqueContext ctx)
    {
        String opl;
        switch (ctx.getChild(2).getText()) {
            case "<": opl = "BL";
            case ">": opl = "BG";
            case "==": opl = "BE";
            case "!=": opl = "BNE";
            default: opl = "BE";
        };
        saveCondition = quads.addQuad(opl,ctx.getChild(1).getText(),ctx.getChild(2).getText(),"");
    }

    @Override public void exitExpressionArithmetique(TinyLangParser.ExpressionArithmetiqueContext ctx)
    {
        if(ctx.child(1) != null & ctx.child(1).getText() == "(")
            this.postStack.push(ctx.child(1).getText());
        if(ctx.IDENTIFIANT() != null)
            this.postStack.push(ctx.IDENTIFIANT().getText());

        if(ctx.opt() != null)

            this.postStack.push(ctx.opt().getText());

        if (ctx.INT() != null)
            this.postStack.push(ctx.INT().getText());

        if (ctx.FLOAT() != null)
            this.postStack.push(ctx.FLOAT().getText());
        if(ctx.child(2) != null & ctx.child(2).getText() == ")")
            this.postStack.push(ctx.child(2).getText());

        if (!(ctx.getParent() instanceof TinyLangParser.ExpressionArithmetiqueContext)){
            boolean b;
            while(this.postStack.size()>0){
                b = true;
                if(this.postStack.get(0).equals("(")){
                    this.tStack.push(this.postStack.get(0));
                    this.postStack.removeFirst();
                    b = false;
                }
                if("+-*/".contains(this.tStack.getFirst())){

                    while (!this.tStack.isEmpty() && "+-*/".contains(this.tStack.peek())  && (priority(this.postStack.get(1))<=priority(this.tStack.peek()))) {
                        this.rStack.push(this.tStack.pop());
                    }
                    this.tStack.push(this.postStack.get(0));
                    this.postStack.removeFirst();
                    b = false;
                }

                if(this.postStack.get(0).equals(")")){
                    while(!this.tStack.isEmpty() && (!this.tStack.peek().equals("("))){
                        this.rStack.push(this.tStack.pop());

                    }
                    this.tStack.pop();
                    this.postStack.remove(0);
                    b = false;
                }

                if(b){
                    this.rStack.push(this.postStack.get(0));
                    this.postStack.removeFirst();
                }
            }
            while(!this.rStack.isEmpty()){
                this.tStack.push(this.rStack.pop());
            }
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

/*-----------------------------------------------------------------------------------------*/
    //retourne la priorité de l'opérateur
    //par defaut retourne 0
    public int priority(String a){
        switch (a) {
            case "-":
            case "+":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0 ;
        }
    }

}