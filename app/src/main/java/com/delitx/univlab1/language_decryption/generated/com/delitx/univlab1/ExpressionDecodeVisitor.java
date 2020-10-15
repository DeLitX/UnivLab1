// Generated from D:/AndroidStudio/Projects/UnivLab1/app/src/main/java/com/delitx/univlab1\ExpressionDecode.g4 by ANTLR 4.8
package com.delitx.univlab1.language_decryption.generated.com.delitx.univlab1;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionDecodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionDecodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code exprCalc}
	 * labeled alternative in {@link ExpressionDecodeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCalc(ExpressionDecodeParser.ExprCalcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(ExpressionDecodeParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code linkExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinkExpr(ExpressionDecodeParser.LinkExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparativeExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparativeExpr(ExpressionDecodeParser.ComparativeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplyExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExpr(ExpressionDecodeParser.MultiplyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(ExpressionDecodeParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(ExpressionDecodeParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minMaxExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinMaxExpr(ExpressionDecodeParser.MinMaxExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesesExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesExpr(ExpressionDecodeParser.ParenthesesExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusExpr}
	 * labeled alternative in {@link ExpressionDecodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpr(ExpressionDecodeParser.MinusExprContext ctx);
}