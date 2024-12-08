package de.ottorohenkohl.riddle.twentyfour.one

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent
import kotlin.math.absoluteValue

@Dependent @Riddle(day = 1, part = 1, year = 2024)
class One : Both() {

    override fun solve(input: String): Long {
        val columns = parseColumns(input)

        val leftSorted = columns.map { it.first }.sorted()
        val rightSorted = columns.map { it.second }.sorted()

        val distances = leftSorted.mapIndexed { index, left -> left - rightSorted[index] }.map { it.absoluteValue }

        return distances.sum().toLong()
    }
}