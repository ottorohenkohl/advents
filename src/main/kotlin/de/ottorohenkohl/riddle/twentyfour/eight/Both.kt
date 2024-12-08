package de.ottorohenkohl.riddle.twentyfour.eight

import de.ottorohenkohl.riddle.Solver
import de.ottorohenkohl.riddle.twentyfour.eight.common.Point

abstract class Both : Solver {

    companion object {
        const val ROW_SEPARATOR = "\n"
    }

    protected fun String.rows(): List<String> {
        return split(ROW_SEPARATOR)
    }

    protected fun List<String>.columns(): List<List<Char>> {
        return map { it.toCharArray().toList() }
    }

    protected fun List<List<Char>>.points(): List<Pair<Char, Point>> {
        return mapIndexed { x, row -> row.mapIndexed { y, char -> char to Point(x, y) } }.flatten().filter { it.first != '.' }
    }

    protected fun List<Pair<Char, Point>>.grouped(): Map<Char, List<Point>> {
        return groupBy { it.first }.mapValues { it.value.map(Pair<Char, Point>::second) }
    }

    protected fun <T, U> List<T>.cartesian(transform: (T, T) -> U): List<U> {
        return mapIndexed { index, first -> (slice(0 until index) + slice(index + 1 until size)).map { second -> transform(first, second) } }.flatten()
    }
}