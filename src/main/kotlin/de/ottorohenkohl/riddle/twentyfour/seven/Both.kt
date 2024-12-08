package de.ottorohenkohl.riddle.twentyfour.seven

import de.ottorohenkohl.riddle.Solver
import java.util.function.BiFunction

abstract class Both : Solver {

    companion object {
        const val ROW_SEPARATOR = "\n"
        const val RESULT_SEPARATOR = ": "
        const val OPERANDS_SEPARATOR = " "
    }

    protected fun String.rows(): List<String> {
        return split(ROW_SEPARATOR)
    }

    protected fun List<String>.equations(): List<Pair<Long, List<Long>>> {
        return map { it.split(RESULT_SEPARATOR) }.map { it[0].toLong() to it[1].split(OPERANDS_SEPARATOR).map(String::toLong) }
    }

    protected fun check(solution: Long, values: List<Long>, operators: List<BiFunction<Long, Long, Long>>): Boolean {
        if (values.size == 1) return values.first() == solution

        return operators.map { check(solution, listOf(it.apply(values[0], values[1])) + values.subList(2, values.size), operators) }.any { it }
    }
}