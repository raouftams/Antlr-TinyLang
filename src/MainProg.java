import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainProg {
    public static void main(String[] args) throws Exception {

        String fileName = null;
        if(args.length>0){
            fileName = args[0];
        }
        InputStream is = System.in;
        if(fileName!=null)
        {
            is = new FileInputStream(fileName);
        }
        CharStream input = new UnbufferedCharStream(is);
        TinyLangLexer lex = new TinyLangLexer(input);
        lex.removeErrorListeners();
        lex.addErrorListener(new ErrorListener());
        lex.setTokenFactory(new CommonTokenFactory(true));

        //POUR RECUPERER les entitées lexicales
        TokenStream tokens = new UnbufferedTokenStream<CommonToken>(lex);

        //instanciation de la classe parser avec les tokens reconnu
        TinyLangParser parser = new TinyLangParser(tokens);
        parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new ErrorListener()); // add ours

        //realisation d'un arbre syntaxique avec les tokens
        //program represente la premiere regle de la grammaire
        ParseTree tree = parser.programme();

        //affichage de l'arbre a l'execution
        Trees.inspect(tree,parser);
        ParseTreeWalker walker = new ParseTreeWalker();

        //instanciation de la classe listener la classe des routines semantiques
        Listener list = new Listener();
        walker.walk(list,tree);
        if(list.nbErreurs == 0) {
            //nberreur si pas d'erreurs semantiques, on affiche les quadruplets sinon on les affiche pas
            //instanciation de la classe quadruplets
            GenerateurQuad quadGen = new GenerateurQuad(list);
            parser.addParseListener(quadGen);
            ParseTreeWalker walker2 = new ParseTreeWalker();
            walker2.walk(quadGen, tree);

            //Instanciation de la classe CodeObjet
            CodeObjet codObj = new CodeObjet(quadGen.quads);
            codObj.transform();
            codObj.afficherCodeObjet();
        }
    }
}
