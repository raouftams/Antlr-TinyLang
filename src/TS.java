import java.util.HashMap;
import java.util.Map;

public class TS {
    static public class Element {
        String name;
        String type;
        String value;
        int declared;

        public Element(String name,  String type, String value, int declared) {
            this.name = name;
            this.type = type;
            this.value = value;
            this.declared = declared;
        }

        //redéfinition de la fonction ToString pour l'affichage qui correspond a la table des symbole
        public String toString()
        {
            return  name + " type: " + this.type + " valeur: " + this.value + " déclarée " + this.declared;
        }

        public void setValue(String val){
            this.value = val;
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
        System.out.println("\n--------------------------------------------------");
        System.out.format("%1s%15s%15s%12s", "Nom", "Type", "Valeur", "Declareé");
        System.out.println("\n--------------------------------------------------");
        for (Map.Entry<String, Element> entry: this.L.entrySet()) {
            System.out.format("%1s%20s%10s%10s",entry.getValue().name, entry.getValue().type, entry.getValue().value,entry.getValue().declared);
            System.out.println("\n--------------------------------------------------");
        }
    }
}