import java.util.ArrayList;

public class Quad {
//TODO: implementation du tableau de quad ainsi que de ces différentes fonction pour generer le code objet!!

    ArrayList<String> q = new ArrayList<String>();

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

    @Override
    public String toString()
    {
        return "("+this.q.get(0)+","+this.q.get(1)+","+this.q.get(3)+","+this.q.get(3)+")";
    }

}
/*
//class elemQuad{
//TODO: creation de la ligne d'un quad

//TODO: afficher quadruplets
//}
*/

