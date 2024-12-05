package de.ottorohenkohl.riddle.twentyfour.five

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 5, part = 2, year = 2024)
class Two : Both() {

    override fun solve(input: String): String {
        val priorityMap = input.priorityMap()
        val invalidUpdates = input.updateRows().filter { row -> row.findInvalid(priorityMap).any { it } }

        return invalidUpdates.map { it.fixUpdate(priorityMap) }.sumOf { it[it.size / 2] }.toString()
    }

    private fun List<Int>.fixUpdate(priorityMap: Map<Int, Set<Int>>): List<Int> {
        return sortedWith { first, second -> getComparator(priorityMap, first, second) }
    }

    private fun getComparator(priorityMap: Map<Int, Set<Int>>, first: Int, second: Int): Int {
        val firstIsBeforeSecond = priorityMap[first]?.contains(second) ?: false
        val secondIsBeforeSecond = priorityMap[second]?.contains(first) ?: false

        return if (firstIsBeforeSecond) 1 else if (secondIsBeforeSecond) -1 else 0
    }
}