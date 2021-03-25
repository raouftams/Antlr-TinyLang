import java.util.HashMap;

public class TS {
    static public class Element {
        String name;
        int type;
        String value;
        int declared;

        public Element(String name,  int type, String value, int declared) {
            this.name = name;
            this.type = type;
            this.value = value;
            this.declared = declared;
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
    public HashMap<String, Element> L = new HashMap<String, Element>();

    //Methode getElement permet de recupérer les variable sauvegarder dans la TS
    public Element getElement(String name) {
        return this.L.get(name);
    }

    //La Methode ContainsElement elle retourner vrai si l'element existe dans la TS et faux sinon
    public boolean containsElement(String name) {
        return this.L.containsKey(name);
    }

    //La methode put permet d'ajouter un element a la TS avec le nom comme clé
    public void addElement(Element e){
        this.L.put(e.name, e);
    }

    //La methode remove(key, value) permet de supprimer un element de la TS
    public void deleteElement(Element e) {
        this.L.remove(e.name, e);
    }

    // afficherTS elle affiche toute la table des Symbole
    public void afficheTS()
    {
        this.L.toString();
    }
}