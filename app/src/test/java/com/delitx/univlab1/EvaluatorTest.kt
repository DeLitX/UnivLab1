package com.delitx.univlab1

import com.delitx.univlab1.data_classes.ExcelItem
import com.delitx.univlab1.language_decryption.Evaluator
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.IllegalArgumentException

class EvaluatorTest {
    @Test
    fun addingOddSymbolsInTheEndTest() {
        assert(
            try {
                testSetup("0asda",0.0)
                false
            }catch(e:IllegalArgumentException) {
                true
            }
        )
    }

    @Test
    fun linkValueTrue() {
        testSetup("A2", 1.0) {
            if (it == "A2") {
                5.0
            } else {
                0.0
            }
        }
    }

    @Test
    fun linkValueFalse() {
        testSetup("A2", 0.0) {
            if (it == "A2") {
                0.0
            } else {
                1.0
            }
        }
    }

    @Test
    fun addTwoDigitsTestTrue() {
        testSetup("1+2", 1.0)
    }

    @Test
    fun addTwoDigitsTestFalse() {
        testSetup("-1+1", 0.0)
    }

    @Test
    fun addTwoLinksTestTrue() {
        testSetup("A1+A2", 1.0) {
            if (it == "A1") {
                1.0
            } else if (it == "A2") {
                1.0
            } else {
                -1.0
            }

        }
    }

    @Test
    fun addTwoLinksTestFalse() {
        testSetup("A1+A2", 0.0) {
            if (it == "A1") {
                1.0
            } else if (it == "A2") {
                -1.0
            } else {
                0.0
            }
        }
    }

    @Test
    fun minusTwoLinksTestTrue() {
        testSetup("A1-A2", 1.0) {
            if (it == "A1") {
                1.0
            } else if (it == "A2") {
                2.0
            } else {
                0.0
            }
        }
    }

    @Test
    fun minusTwoLinksTestFalse() {
        testSetup("A1-A2", 0.0) {
            if (it == "A1") {
                1.0
            } else if (it == "A2") {
                1.0
            } else {
                0.0
            }
        }
    }

    @Test
    fun minusTwoNumbersTestTrue() {
        testSetup("1-2", 1.0)
    }

    @Test
    fun minusTwoNumbersTestFalse() {
        testSetup("1-1", 0.0)
    }

    @Test
    fun multipleTwoNumbersTestFalse() {
        testSetup("1*0", 0.0)
    }

    @Test
    fun multipleTwoNumbersTestTrue() {
        testSetup("1*2", 1.0)
    }

    @Test
    fun divideTwoNumbersTestFalse() {
        testSetup("0/5", 0.0)
    }

    @Test
    fun divideTwoNumbersTestTrue() {
        testSetup("1/5", 1.0)
    }

    @Test
    fun divTwoNumbersTestTrue() {
        testSetup("6 div 5", 1.0)
    }

    @Test
    fun divTwoNumbersTestFalse() {
        testSetup("1 div 5", 0.0) //
    }

    @Test
    fun modTwoNumbersTestTrue() {
        testSetup("1 mod 5", 1.0)
    }

    @Test
    fun modTwoNumbersTestFalse() {
        testSetup("1 mod 5 -1", 0.0) //
    }

    @Test
    fun minFalse() {
        testSetup("min(2,5)-2", 0.0)
    }

    @Test
    fun maxTrue() {
        testSetup("max(0,1)", 1.0)
    }

    @Test
    fun equalsTrue() {
        testSetup("1=1", 1.0)
    }

    @Test
    fun equalsFalse() {
        testSetup("1=5", 0.0)
    }

    @Test
    fun lessFalse() {
        testSetup("2<1", 0.0)
    }

    @Test
    fun lessTrue() {
        testSetup("1<5", 1.0)
    }

    @Test
    fun moreFalse() {
        testSetup("1>5", 0.0)
    }

    @Test
    fun moreTrue() {
        testSetup("3>1", 1.0)
    }

    @Test
    fun notFalse() {
        testSetup("!5", 0.0)
    }

    @Test
    fun complicatedExpressionTrue() {
        testSetup("!(max(5,2)/min(5,7)-1)", 1.0)
    }

    @Test
    fun complicatedExpressionFalse() {
        testSetup("!max(5,2)/min(5,7)", 0.0)
    }

    @Test
    fun complicatedExpressionLinksTrue() {
        testSetup("!(max(A2,A3)/min(A2,A4)-1)", 1.0) {
            when (it) {
                "A2" -> 5.0
                "A3" -> 2.0
                "A4" -> 7.0
                else -> 0.0
            }
        }
    }

    @Test
    fun complicatedExpressionLinksFalse() {
        testSetup("!(max(A2,A3)/min(A2,A4))", 0.0) {
            when (it) {
                "A2" -> 5.0
                "A3" -> 2.0
                "A4" -> 7.0
                else -> 0.0
            }
        }
    }

    private fun testSetup(query: String, bool: Double) {
        testSetup(query, bool) { 0.0 }
    }

    private fun testSetup(query: String, bool: Double, getLink: (String) -> Double) {
        val evaluator =
            Evaluator(
                ExcelItem(name = "A1", query = query),
                object : Evaluator.EvaluateHelper {
                    override suspend fun getClassesFromDb(list: Set<String>): Set<ExcelItem> {
                        return setOf()
                    }

                    override suspend fun getDependenciesByNames(list: Set<String>): Set<String> {
                        return setOf()
                    }

                    override fun getLinkValue(link: String): Double {
                        return getLink(link)
                    }

                })
        runBlocking {
            val result = evaluator.evaluate()
            assertEquals(bool, result, 0.01)
        }
    }
}