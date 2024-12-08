package de.ottorohenkohl.riddle.twentyfour.three

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 3, part = 1, year = 2024)
class One : Both() {

    override fun solve(input: String): Long {
        val parts = MUL_REGEX.findAll(input).map { it.groupValues[1] to it.groupValues[2] }

        return parts.map { it.first.toInt() * it.second.toInt() }.sum().toLong()
    }
}