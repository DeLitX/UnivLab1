// Generated from D:/AndroidStudio/Projects/UnivLab1/app/src/main/java/com/delitx/univlab1\ExpressionDecode.g4 by ANTLR 4.8
package com.delitx.univlab1.language_decryption.generated.com.delitx.univlab1;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionDecodeParser}.
 */
public interface ExpressionDecodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code exprCalc}
	 * labeled alternative in {@link ExpressionDecodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprCalc(ExpressionDecodeParser.ExprCalcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprCalc}
	 * labeled alternative in {@link ExpressionDecodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprCalc(ExpressionDecodeParser.ExprCalcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(ExpressionDecodeParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(ExpressionDecodeParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code linkExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLinkExpr(ExpressionDecodeParser.LinkExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code linkExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLinkExpr(ExpressionDecodeParser.LinkExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparativeExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparativeExpr(ExpressionDecodeParser.ComparativeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparativeExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparativeExpr(ExpressionDecodeParser.ComparativeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplyExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpr(ExpressionDecodeParser.MultiplyExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplyExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpr(ExpressionDecodeParser.MultiplyExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(ExpressionDecodeParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(ExpressionDecodeParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(ExpressionDecodeParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(ExpressionDecodeParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minMaxExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinMaxExpr(ExpressionDecodeParser.MinMaxExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minMaxExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinMaxExpr(ExpressionDecodeParser.MinMaxExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesesExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesExpr(ExpressionDecodeParser.ParenthesesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesesExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesExpr(ExpressionDecodeParser.ParenthesesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinusExpr(ExpressionDecodeParser.MinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinusExpr(ExpressionDecodeParser.MinusExprContext ctx);
}