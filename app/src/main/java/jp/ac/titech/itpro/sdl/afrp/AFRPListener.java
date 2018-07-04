// Generated from AFRP.g4 by ANTLR 4.5
package jp.ac.titech.itpro.sdl.afrp;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AFRPParser}.
 */
public interface AFRPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AFRPParser#topLevel}.
	 * @param ctx the parse tree
	 */
	void enterTopLevel(AFRPParser.TopLevelContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#topLevel}.
	 * @param ctx the parse tree
	 */
	void exitTopLevel(AFRPParser.TopLevelContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#inputdef}.
	 * @param ctx the parse tree
	 */
	void enterInputdef(AFRPParser.InputdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#inputdef}.
	 * @param ctx the parse tree
	 */
	void exitInputdef(AFRPParser.InputdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#outputdef}.
	 * @param ctx the parse tree
	 */
	void enterOutputdef(AFRPParser.OutputdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#outputdef}.
	 * @param ctx the parse tree
	 */
	void exitOutputdef(AFRPParser.OutputdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(AFRPParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(AFRPParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(AFRPParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(AFRPParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(AFRPParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(AFRPParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpMulDiv}.
	 * @param ctx the parse tree
	 */
	void enterBinOpMulDiv(AFRPParser.BinOpMulDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpMulDiv}.
	 * @param ctx the parse tree
	 */
	void exitBinOpMulDiv(AFRPParser.BinOpMulDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpAddSub}.
	 * @param ctx the parse tree
	 */
	void enterBinOpAddSub(AFRPParser.BinOpAddSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpAddSub}.
	 * @param ctx the parse tree
	 */
	void exitBinOpAddSub(AFRPParser.BinOpAddSubContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpShift}.
	 * @param ctx the parse tree
	 */
	void enterBinOpShift(AFRPParser.BinOpShiftContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpShift}.
	 * @param ctx the parse tree
	 */
	void exitBinOpShift(AFRPParser.BinOpShiftContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpCompare}.
	 * @param ctx the parse tree
	 */
	void enterBinOpCompare(AFRPParser.BinOpCompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpCompare}.
	 * @param ctx the parse tree
	 */
	void exitBinOpCompare(AFRPParser.BinOpCompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpEqual}.
	 * @param ctx the parse tree
	 */
	void enterBinOpEqual(AFRPParser.BinOpEqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpEqual}.
	 * @param ctx the parse tree
	 */
	void exitBinOpEqual(AFRPParser.BinOpEqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpBitAnd}.
	 * @param ctx the parse tree
	 */
	void enterBinOpBitAnd(AFRPParser.BinOpBitAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpBitAnd}.
	 * @param ctx the parse tree
	 */
	void exitBinOpBitAnd(AFRPParser.BinOpBitAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpBitXor}.
	 * @param ctx the parse tree
	 */
	void enterBinOpBitXor(AFRPParser.BinOpBitXorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpBitXor}.
	 * @param ctx the parse tree
	 */
	void exitBinOpBitXor(AFRPParser.BinOpBitXorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpBitOr}.
	 * @param ctx the parse tree
	 */
	void enterBinOpBitOr(AFRPParser.BinOpBitOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpBitOr}.
	 * @param ctx the parse tree
	 */
	void exitBinOpBitOr(AFRPParser.BinOpBitOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpLogicOr}.
	 * @param ctx the parse tree
	 */
	void enterBinOpLogicOr(AFRPParser.BinOpLogicOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpLogicOr}.
	 * @param ctx the parse tree
	 */
	void exitBinOpLogicOr(AFRPParser.BinOpLogicOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#binOpLogicAnd}.
	 * @param ctx the parse tree
	 */
	void enterBinOpLogicAnd(AFRPParser.BinOpLogicAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#binOpLogicAnd}.
	 * @param ctx the parse tree
	 */
	void exitBinOpLogicAnd(AFRPParser.BinOpLogicAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link AFRPParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(AFRPParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link AFRPParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(AFRPParser.NumberContext ctx);
}