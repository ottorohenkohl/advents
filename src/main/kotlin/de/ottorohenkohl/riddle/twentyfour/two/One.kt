package de.ottorohenkohl.riddle.twentyfour.two

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 2, part = 1, year = 2024)
class One : Both() {

    override fun solve(input: String): String {
        return parseColumns(input).count { it.isMonotonous() && it.maxDifferences(3) }.toString()
    }
}