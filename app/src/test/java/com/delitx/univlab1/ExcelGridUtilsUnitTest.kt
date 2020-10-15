package com.delitx.univlab1

import com.delitx.univlab1.algorithms.ExcelGridUtils
import org.junit.Test

import org.junit.Assert.*

class ExcelGridUtilsUnitTest {
    @Test
    fun nameDecodeA1() {
        assertEquals(Pair(1,1),ExcelGridUtils.decodeName("A1"))
    }
    @Test
    fun nameDecodeF1() {
        assertEquals(Pair(6,1),ExcelGridUtils.decodeName("F1"))
    }

    @Test
    fun nameDecodeA6() {
        assertEquals(Pair(1,6),ExcelGridUtils.decodeName("A6"))
    }
    @Test
    fun nameDecodeF8() {
        assertEquals(Pair(6,8),ExcelGridUtils.decodeName("F8"))
    }
    @Test
    fun nameDecodeABC8() {
        assertEquals(Pair(731,8),ExcelGridUtils.decodeName("ABC8"))
    }
    @Test
    fun nameDecodeF731() {
        assertEquals(Pair(6,731),ExcelGridUtils.decodeName("F731"))
    }
    @Test
    fun nameEncode1_1(){
        assertEquals("A1",ExcelGridUtils.encodeName(1,1))
    }
    @Test
    fun nameEncode6_1(){
        assertEquals("F1",ExcelGridUtils.encodeName(6,1))
    }
    @Test
    fun nameEncode1_6(){
        assertEquals("A6",ExcelGridUtils.encodeName(1,6))
    }
    @Test
    fun nameEncode6_8(){
        assertEquals("F8",ExcelGridUtils.encodeName(6,8))
    }@Test
    fun nameEncode731_8(){
        assertEquals("ABC8",ExcelGridUtils.encodeName(731,8))
    }
    @Test
    fun nameEncode6_731(){
        assertEquals("F731",ExcelGridUtils.encodeName(6,731))
    }
    @Test
    fun numberToString1(){
        assertEquals("A",ExcelGridUtils.numberToString(1))
    }
    @Test
    fun numberToString731(){
        assertEquals("ABC",ExcelGridUtils.numberToString(731))
    }
    @Test
    fun stringToNumberA(){
        assertEquals(1,ExcelGridUtils.stringToNumber("A"))
    }
    @Test
    fun stringToNumberABC(){
        assertEquals(731,ExcelGridUtils.stringToNumber("ABC"))
    }}