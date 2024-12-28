package de.ottorohenkohl.riddle.twentyfour.one

import de.ottorohenkohl.riddle.Solver

abstract class Both : Solver {

    companion object {
        const val ROW_SEPARATOR = "\n"
        const val COLUMN_SEPARATOR = "   "
    }

    fun parseColumns(input: String): List<Pair<Int, Int>> {
        return input.split(ROW_SEPARATOR).map { it.split(COLUMN_SEPARATOR) }.map { it[0].toInt() to it[1].toInt() }
    }
}