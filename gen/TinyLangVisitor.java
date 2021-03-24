// Generated from C:/Users/Raouftams/IdeaProjects/TinyLang\TinyLang.g4 by ANTLR 4.9.1

    package antlr;
    
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TinyLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TinyLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#programme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramme(TinyLangParser.ProgrammeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(TinyLangParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(TinyLangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(TinyLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#identifiants}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifiants(TinyLangParser.IdentifiantsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructions(TinyLangParser.InstructionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(TinyLangParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#affectation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectation(TinyLangParser.AffectationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TinyLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(TinyLangParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#optelse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptelse(TinyLangParser.OptelseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#boucle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoucle(TinyLangParser.BoucleContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#scan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScan(TinyLangParser.ScanContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(TinyLangParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyLangParser#print_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_val(TinyLangParser.Print_valContext ctx);
}