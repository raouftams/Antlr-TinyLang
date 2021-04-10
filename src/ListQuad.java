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
        LinkedList<Integer> nEtiq = new LinkedList<>();
        System.out.println("\n \033[0;97m \t  Liste de quadruplés  ");
        System.out.println("----------------------------------------");
        int i = 1;
        for (Quad q: this.quads) {
            if (q.getOp1().contains("Etiq")){
                nEtiq.add(Integer.parseInt(q.getOp1().substring(4)));
            }
            if (!nEtiq.isEmpty() && nEtiq.getFirst() == i){
                nEtiq.removeFirst();
                System.out.println("\033[0;94m Etiq"+(i) + "->\033[0;97m " + q.toString());
            }
            else System.out.println("\033[0;97m \t\t" + q.toString());
            i++;
        }

    }
}
