package de.ottorohenkohl.riddle.twentyfour.five

import de.ottorohenkohl.riddle.Solver

abstract class Both : Solver {

    companion object {
        const val ROW_SEPARATOR = "\n"
        const val PART_SEPARATOR = "\n\n"
        const val PRIORITY_SEPARATOR = "|"
        const val PAGE_SEPARATOR = ","
    }

    private fun String.parsePart(number: Int): String {
        return split(PART_SEPARATOR)[number]
    }

    private fun String.priorityRows(): List<Pair<Int, Int>> {
        return parsePart(0).split(ROW_SEPARATOR).map { it.split(PRIORITY_SEPARATOR) }
            .map { it[0].toInt() to it[1].toInt() }
    }

    protected fun List<Int>.findInvalid(priorityMap: Map<Int, Set<Int>>): List<Boolean> {
        return withIndex().map { slice(0 until it.index).intersect(priorityMap[it.value].orEmpty()).isNotEmpty() }
    }

    protected fun String.priorityMap(): Map<Int, Set<Int>> {
        return priorityRows().groupBy({ pair -> pair.first }, { pair -> pair.second }).mapValues { it.value.toSet() }
    }

    protected fun String.updateRows(): List<List<Int>> {
        return parsePart(1).split(ROW_SEPARATOR).map { it.split(PAGE_SEPARATOR) }.map { it.map(String::toInt) }
    }
}