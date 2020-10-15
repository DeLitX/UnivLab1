package com.delitx.univlab1.language_decryption

import com.delitx.univlab1.data_classes.Dependency
import com.delitx.univlab1.data_classes.ExcelItem
import com.delitx.univlab1.language_decryption.generated.com.delitx.univlab1.ExpressionDecodeLexer
import com.delitx.univlab1.language_decryption.generated.com.delitx.univlab1.ExpressionDecodeParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class Evaluator(val item: ExcelItem, val helper: EvaluateHelper) {
    private val dependsOn: MutableSet<Dependency> = mutableSetOf()
    suspend fun evaluate(): Double {

        val inputStream = CharStreams.fromString(item.query)
        val grammarLexer = ExpressionDecodeLexer(inputStream)
        grammarLexer.addErrorListener(ErrorListener.getInstance())
        val tokens = CommonTokenStream(grammarLexer)
        val parser = ExpressionDecodeParser(tokens)
        parser.addErrorListener(ErrorListener.getInstance())
        val tree = parser.expr()
        val tempVisitor =
            ExpressionDecoderVisitor(object : ExpressionDecoderVisitor.RecogniseHelper {
                override fun getLinkValue(link: String): Double {
                    dependsOn.add(Dependency(item.name.toUpperCase(), link.toUpperCase()))
                    return 1.0
                }
            })
        tempVisitor.visit(tree)
        val tempSet = mutableSetOf<String>()
        for (i in dependsOn) {
            tempSet.add(i.to)
        }
        if (foundCycles(mutableSetOf(item.name), tempSet)) {
            throw IllegalArgumentException()
        }

        val visitor = ExpressionDecoderVisitor(helper)
        val result = visitor.visit(tree)
        return if (result == 0.0) 0.0 else 1.0
    }

    fun getListOfDependencies(): List<Dependency> {
        return dependsOn.toMutableList()
    }

    private suspend fun foundCycles(
        startLinks: MutableSet<String>,
        lastLinks: MutableSet<String>
    ): Boolean {
        val fromDB = helper.getClassesFromDb(lastLinks)
        if (fromDB.isEmpty()) {
            return false
        }
        val fromDbLinks = classesListToLinksList(fromDB)
        val temp = mutableSetOf(item.name)
        temp.addAll(startLinks)
        val sameElements = temp.intersect(fromDbLinks)
        return if (sameElements.isNotEmpty()) {
            true
        } else {
            foundCycles(startLinks, fromDbLinks)
        }
    }

    private suspend fun classesListToLinksList(list: Set<ExcelItem>): MutableSet<String> {
        val temp = mutableSetOf<String>()
        for (i in list) {
            temp.add(i.name)
        }
        return helper.getDependenciesByNames(temp).toMutableSet()
    }

    interface EvaluateHelper : ExpressionDecoderVisitor.RecogniseHelper {
        suspend fun getClassesFromDb(list: Set<String>): Set<ExcelItem>
        suspend fun getDependenciesByNames(list: Set<String>): Set<String>
    }
}