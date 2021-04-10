import java.util.LinkedList;

public class ListQuad {
    LinkedList<Quad> quads = new LinkedList<>();
    public int addQuad(String s1,String s2,String s3,String s4)
    {
        return addQuad(new Quad(s1,s2,s3,s4));
    }

    public int addQuad(Quad quad)
    {
        quads.add(quad);
        return quads.size()-1;
    }
    //retourne le quad à l'index index
    public Quad getQuad(int index)
    {
        return quads.get(index);
    }

    //retourne l'index du quad
    public int size()
    {
        return quads.size();
    }

    public void afficherQuad(){
        System.out.println("\n  Liste de quadruplés  ");
        System.out.println("-----------------------");
        int i = 0;
        for (Quad q: this.quads) {
            System.out.println("\033[0;94m"+(i+1) + "\033[0;97m - " + q.toString());
            i++;
        }

    }
}
