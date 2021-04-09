import java.util.ArrayList;

public class Quad {
    ArrayList<String> q = new ArrayList<String>(4);

    public Quad(String[] quadr){
        this.q.add(quadr[1]);
        this.q.add(quadr[2]);
        this.q.add(quadr[3]);
        this.q.add(quadr[4]);
    }

    public Quad(String s1, String s2, String s3, String s4){
        q = new ArrayList<String>();
        q.add(s1);
        q.add(s2);
        q.add(s3);
        q.add(s4);
    }

    public ArrayList<String> getQ() {
        return q;
    }

    public void setQ(ArrayList<String> q) {
        this.q = q;
    }


    public String get(int index)
    {
        return this.q.get(index);
    }

    public void set(int index, String s)
    {
        this.q.set(index,s);
    }

    public String getOpt(){
        return this.q.get(0);
    }

    public String getOp1(){
        return this.q.get(1);
    }

    public String getOp2(){
        return this.q.get(2);
    }

    public String getResult(){
        return this.q.get(3);
    }
    @Override
    public String toString()
    {
        return "("+this.q.get(0)+","+this.q.get(1)+","+this.q.get(3)+","+this.q.get(3)+")";
    }

}
