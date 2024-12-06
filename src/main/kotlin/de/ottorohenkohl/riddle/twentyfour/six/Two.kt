package de.ottorohenkohl.riddle.twentyfour.six

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.twentyfour.six.common.Position
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 6, part = 2, year = 2024)
class Two : Both() {

    @field:Riddle(day = 6, part = 1, year = 2024)
    private lateinit var one: One

    override fun solve(input: String): String {
        val relevant = one.solve(input).let { one.visited }.map { it.first }

        return input.filterIndexed { index, _ -> variation(input, index, relevant) }.count().toString()
    }

    private fun variation(input: String, index: Int, relevant: List<Position>): Boolean {
        println(index)

        if (input[index] != '.') return false
        if (relevant.map { input.width() * it.y + it.x }.contains(index).not()) return false

        try { one.solve(input.replaceRange(index, index + 1, "#")).let { return false } } catch (_: Exception) { return true }
    }
}