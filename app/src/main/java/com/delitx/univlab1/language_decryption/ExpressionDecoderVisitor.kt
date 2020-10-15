package com.delitx.univlab1.language_decryption

import com.delitx.univlab1.language_decryption.generated.com.delitx.univlab1.*
import org.antlr.v4.runtime.tree.ErrorNode
import kotlin.math.max
import kotlin.math.min


class ExpressionDecoderVisitor(val helper: RecogniseHelper) :
    ExpressionDecodeBaseVisitor<Double>() {
    override fun visitNotExpr(ctx: ExpressionDecodeParser.NotExprContext?): Double {
        return if (visit(ctx?.expression()) == 0.0) {
            1.0
        } else {
            0.0
        }
    }

    override fun visitExprCalc(ctx: ExpressionDecodeParser.ExprCalcContext?): Double {
        return visit(ctx?.expression())
    }

    override fun visitMinusExpr(ctx: ExpressionDecodeParser.MinusExprContext?): Double {
        return -visit(ctx?.expression())
    }

    override fun visitComparativeExpr(ctx: ExpressionDecodeParser.ComparativeExprContext?): Double {
        return boolToDouble(
            if (ctx?.operatorToken?.type == ExpressionDecodeLexer.LESS) {
                visit(ctx.expression(0)) < visit(ctx.expression(1))
            } else if (ctx?.operatorToken?.type == ExpressionDecodeLexer.MOR) {
                visit(ctx.expression(0)) > visit(ctx.expression(1))
            } else {
                visit(ctx?.expression(0)) == visit(ctx?.expression(1))
            }
        )
    }

    override fun visitMinMaxExpr(ctx: ExpressionDecodeParser.MinMaxExprContext?): Double {
        val value1 = visit(ctx?.expression(0))
        val value2 = visit(ctx?.expression(1))
        return if (ctx?.operatorToken?.type == ExpressionDecodeLexer.MIN) {
            min(value1, value2)
        } else {
            max(value1, value2)
        }
    }

    override fun visitLinkExpr(ctx: ExpressionDecodeParser.LinkExprContext?): Double {
        if (ctx == null) {
            return 0.0
        }
        return helper.getLinkValue(ctx.text.toUpperCase())
    }

    override fun visitMultiplyExpr(ctx: ExpressionDecodeParser.MultiplyExprContext?): Double {
        return when (ctx?.operatorToken?.type) {
            ExpressionDecodeLexer.MULTIPLY -> visit(ctx.expression(0)) * visit(ctx.expression(1))
            ExpressionDecodeLexer.DIVIDE -> visit(ctx.expression(0)) / visit(ctx.expression(1))
            ExpressionDecodeLexer.DIV -> {
                val value1 = visit(ctx.expression(0))
                val value2 = visit(ctx.expression(1))
                (value1- value1 % value2) / value2
            }
            ExpressionDecodeLexer.MOD -> visit(ctx.expression(0)) % visit(ctx.expression(1))
            else -> 0.0
        }
    }

    override fun visitAdditiveExpr(ctx: ExpressionDecodeParser.AdditiveExprContext?): Double? {
        return if (ctx?.operatorToken?.type == ExpressionDecodeLexer.ADD) {
            visit(ctx.expression(0)) + visit(ctx.expression(1))
        } else {
            visit(ctx?.expression(0)) - visit(ctx?.expression(1))
        }
    }


    override fun visitParenthesesExpr(ctx: ExpressionDecodeParser.ParenthesesExprContext?): Double {
        return visit(ctx?.expression())
    }

    override fun visitBoolExpr(ctx: ExpressionDecodeParser.BoolExprContext?): Double? {
        val number = ctx?.text
        return number?.toDouble()
    }

    override fun visitErrorNode(node: ErrorNode?): Double {
        throw IllegalArgumentException()
    }

    interface RecogniseHelper {
        fun getLinkValue(link: String): Double
    }

    private fun boolToDouble(bool: Boolean?): Double {
        return if (bool == true) {
            1.0
        } else {
            0.0
        }
    }

}