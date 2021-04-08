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
    }
}
