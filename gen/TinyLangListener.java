// Generated from C:/Users/Raouftams/IdeaProjects/TinyLang\TinyLang.g4 by ANTLR 4.9.1

    package antlr;
    
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinyLangParser}.
 */
public interface TinyLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#programme}.
	 * @param ctx the parse tree
	 */
	void enterProgramme(TinyLangParser.ProgrammeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#programme}.
	 * @param ctx the parse tree
	 */
	void exitProgramme(TinyLangParser.ProgrammeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(TinyLangParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(TinyLangParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(TinyLangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(TinyLangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TinyLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TinyLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#identifiants}.
	 * @param ctx the parse tree
	 */
	void enterIdentifiants(TinyLangParser.IdentifiantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#identifiants}.
	 * @param ctx the parse tree
	 */
	void exitIdentifiants(TinyLangParser.IdentifiantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(TinyLangParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(TinyLangParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(TinyLangParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(TinyLangParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#affectation}.
	 * @param ctx the parse tree
	 */
	void enterAffectation(TinyLangParser.AffectationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#affectation}.
	 * @param ctx the parse tree
	 */
	void exitAffectation(TinyLangParser.AffectationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#expressionArithmetique}.
	 * @param ctx the parse tree
	 */
	void enterExpressionArithmetique(TinyLangParser.ExpressionArithmetiqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#expressionArithmetique}.
	 * @param ctx the parse tree
	 */
	void exitExpressionArithmetique(TinyLangParser.ExpressionArithmetiqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#expressionLogique}.
	 * @param ctx the parse tree
	 */
	void enterExpressionLogique(TinyLangParser.ExpressionLogiqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#expressionLogique}.
	 * @param ctx the parse tree
	 */
	void exitExpressionLogique(TinyLangParser.ExpressionLogiqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(TinyLangParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(TinyLangParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#optelse}.
	 * @param ctx the parse tree
	 */
	void enterOptelse(TinyLangParser.OptelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#optelse}.
	 * @param ctx the parse tree
	 */
	void exitOptelse(TinyLangParser.OptelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#boucle}.
	 * @param ctx the parse tree
	 */
	void enterBoucle(TinyLangParser.BoucleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#boucle}.
	 * @param ctx the parse tree
	 */
	void exitBoucle(TinyLangParser.BoucleContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#scan}.
	 * @param ctx the parse tree
	 */
	void enterScan(TinyLangParser.ScanContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#scan}.
	 * @param ctx the parse tree
	 */
	void exitScan(TinyLangParser.ScanContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(TinyLangParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(TinyLangParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#print_val}.
	 * @param ctx the parse tree
	 */
	void enterPrint_val(TinyLangParser.Print_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#print_val}.
	 * @param ctx the parse tree
	 */
	void exitPrint_val(TinyLangParser.Print_valContext ctx);
}