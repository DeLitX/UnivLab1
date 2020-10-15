package com.delitx.univlab1.algorithms

class ExcelGridUtils {
    companion object {
        val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        fun numberToString(number: Int): String {
            var temp = number-1
            var result = ""
            while (true) {
                if (temp < ALPHABET.length) {
                    result += ALPHABET[temp]
                    break
                } else {
                    result += ALPHABET[temp % ALPHABET.length]
                    temp /= ALPHABET.length
                    temp--
                }
            }
            return result.reversed()
        }

        fun stringToNumber(word: String): Int {
            var result = 0
            val temp = word.toUpperCase()
            for (i in temp) {
                result *= ALPHABET.length
                result += ALPHABET.indexOf(i) + 1
            }
            return result
        }

        fun decodeName(name: String): Pair<Int, Int> {
            val lastIndex = name.indexOfLast { ALPHABET.indexOf(it) != -1 }
            val word=name.substring(0,lastIndex+1)
            val number=name.substring(lastIndex+1,name.length).toInt()
            return Pair(stringToNumber(word.toUpperCase()),number)
        }
        fun encodeName(columnPosition:Int,rowPosition:Int): String {
            return numberToString(columnPosition)+rowPosition
        }
    }
}