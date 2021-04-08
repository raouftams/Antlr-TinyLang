import java.util.Stack;


public class Transform{
    Stack<String> pilep = new Stack<String>();
    Stack<String> piler = new Stack<String>();

    public boolean isNumber(String s){
        try {
            Double.parseDouble(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public boolean Operator(String s){
        return !(isNumber(s) | s =="(" | s ==")");
    }

    public void stackAE(String expression){
        String b;
        Character c;
        
        for (int i = 0; i < expression.length(); i++) {
            c= expression.charAt(i);    

            if(isNumber(c.toString())){ piler.push(c.toString());}
            if(c =='('){pilep.push(c.toString());}
            if(Operator(c.toString())){
                while (!pilep.empty() & Operator(pilep.peek()) & priorité de la pile p sup ou egal la prio de c ) {
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

    public void evaluation(){
        String s,x,y,z;
        while(!pilep.empty()){
            s = pilep.pop();
            if(isNumber(s)){
                piler.push(s);
            }
            else{
                x = piler.pop();
                y = piler.pop();
                z = eval(y,x,s);
                piler.push(z);

            }
        }

    }

}