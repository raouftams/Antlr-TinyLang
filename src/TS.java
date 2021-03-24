import java.util.ArrayList;
public class TS {
    static public class Element {
        String name;
        int type;

        public Element(String name,  int type) {
            this.name = name;
            this.type = type;
        }

        public Element(Element element) {
            this.name = element.name;
            this.type=element.type;
        }
        //redéfinition de la fonction ToString pour l'affichage qui correspond a la table des symbole
        public String toString()
        {
            String typeS;
            if(this.type == 1){
                typeS = "int";
            }else{
                if(this.type == 2) {
                    typeS = "float";
                }else{
                    typeS = "string";
                }
            }
            return  name + " type: " + typeS;
        }
    }
    // L va contenir chaque variable du programme et son type
    public ArrayList<Element> L = new ArrayList<Element>();
    //Methode getElement permet de recupérer les variable sauvegarder dans la TS
    public Element getElement(String name)
    {
        for (int i = 0; i < L.size(); i++) {
            if(L.get(i).name.compareTo(name)==0)
                return L.get(i);
        }
        return null;
    }
    //La Methode ContainsElement elle retourner vrai si l'element existe dans la TS
    // sinon elle retourne faux
    public boolean containsElement(String name)
    {
        return getElement(name) != null;
    }

    //La methode addElement permet d'ajouter u element a la TS
    public void addElement(Element e)
    {
        L.add(e);
    }
    //La methode deleteElement permet de supprimer un element de la TS
    public void deleteElement(Element e)
    {
        L.remove(e);
    }
    // afficherTS elle affiche toute la table des Symbole
    public void afficheTS()
    { int i;
        for(i=0;i<L.size();i++)
        {
            System.out.println("\t "+L.get(i).name +"\t \t "+ L.get(i).type);
        }
    }
    public Element getElement(int i)
    {
        return L.get(i);
    }
}