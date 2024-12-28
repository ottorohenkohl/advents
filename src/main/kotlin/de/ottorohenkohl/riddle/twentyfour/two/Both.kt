package de.ottorohenkohl.riddle.twentyfour.two

import de.ottorohenkohl.riddle.Solver
import kotlin.math.absoluteValue
import kotlin.math.sign

abstract class Both : Solver {

    companion object {
        const val ROW_SEPARATOR = "\n"
        const val COLUMN_SEPARATOR = " "
    }

    fun parseColumns(input: String): List<List<Int>> {
        return input.split(ROW_SEPARATOR).map { it.split(COLUMN_SEPARATOR) }.map { it.map(String::toInt) }
    }

    protected fun List<Int>.isMonotonous(): Boolean {
        for (index in 2..<size) {
            val lastSign = (get(index - 1) - get(index - 2)).sign
            val currentSign = (get(index) - get(index - 1)).sign

            if (currentSign != lastSign || currentSign == 0) return false
        }

        return true
    }

    protected fun List<Int>.maxDifferences(maximum: Int): Boolean {
        for (index in 1..<size) {
            val difference = (get(index) - get(index - 1)).absoluteValue

            if (difference > maximum) return false
        }

        return true
    }
}