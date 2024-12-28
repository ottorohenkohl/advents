package de.ottorohenkohl.riddle.twentyfour.two

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent

@Dependent
@Riddle(day = 2, part = 2, year = 2024)
class Second : Both() {

    override fun solve(input: String): Long {
        return parseColumns(input).count { it.validVariation() }.toLong()
    }

    private fun List<Int>.validVariation(): Boolean {
        for (index in indices) {
            val variation = filterIndexed { at, _ -> at != index }

            if (variation.isMonotonous() && variation.maxDifferences(3)) return true
        }

        return false
    }
}