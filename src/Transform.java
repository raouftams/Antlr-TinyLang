import java.util.Stack;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Transform{

    Stack<String> pilep = new Stack<String>();
    Stack<String> piler = new Stack<String>();
    
    //check si le caractere est un number
    public boolean isNumber(String s){
        try {
            Double.parseDouble(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    //check si le charactére est un Operateur arithmétique
    public boolean Operator(String s){
        return !(isNumber(s) | s =="(" | s ==")");
    }

    //transforme l"expression caractére par caractére en infixé dans une pile
    //puis la remet en postfixé dans l'autre pile
    public void stackAE(String expression){
        String b;
        Character c;
        
        for (int i = 0; i < expression.length(); i++) {
            c= expression.charAt(i);
            if(isNumber(c.toString())){ piler.push(c.toString());}
            if(c =='('){pilep.push(c.toString());}
            if(Operator(c.toString())){
                
                while (!pilep.empty() & Operator(pilep.peek()) /* & priorité de l'operateur de p vs priorité de l'operateur de r*/) {
                    b = pilep.pop();
                    piler.push(b);
                }
                pilep.push(c.toString());
            }

            if(c == ')'){ 
                while(!pilep.empty() & (pilep.peek()!= "(")){
                    piler.push(pilep.pop());
                                        
                }
                pilep.pop();
            }
        }

        while (!piler.empty()) {
            pilep.push(piler.pop());
        }
        
    }

    //evalue la forme postfixé contenue dans la pile p
    // retourne le resultat en type string
    public String evaluationpile() throws ScriptException{
        String s,x,y;
        String z = "";
        while(!pilep.empty()){
            s = pilep.pop();
            if(isNumber(s)){
                piler.push(s);
            }
            else{
                x = piler.pop();
                y = piler.pop();
                z = y+s+x;
                z = evalExpression(z);
                piler.push(z);

            }
        }

        return "";

    }

    //prends une expression arithmetique de type string en entré
    //retourne ça valeure en type string
    public String evalExpression(String ExpStr)throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return engine.eval((ExpStr)).toString();
        } 

}