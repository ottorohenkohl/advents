package de.ottorohenkohl.riddle.twentyfour.five

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 5, part = 1, year = 2024)
class One : Both() {

    override fun solve(input: String): String {
        val priorityMap = input.priorityMap()
        val validUpdates = input.updateRows().filter { row -> row.findInvalid(priorityMap).none { it } }

        return validUpdates.sumOf { it[it.size / 2] }.toString()
    }
}