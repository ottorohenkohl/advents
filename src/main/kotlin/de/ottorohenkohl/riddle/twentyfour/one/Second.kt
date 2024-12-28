package de.ottorohenkohl.riddle.twentyfour.one

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 1, part = 2, year = 2024)
class Second : Both() {

    override fun solve(input: String): String {
        val columns = parseColumns(input)

        val frequenciesLeft = columns.map { it.first }.groupingBy { it }.eachCount()
        val frequenciesRight = columns.map { it.second }.groupingBy { it }.eachCount()

        val scores = frequenciesLeft.map { it.key * it.value * (frequenciesRight[it.key] ?: 0) }

        return scores.sum().toString()
    }
}