package de.ottorohenkohl.riddle.twentyfour.three

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.Solver
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 3, part = 2, year = 2024)
class Second : Both() {

    @field:Riddle(day = 3, part = 1, year = 2024)
    lateinit var one: Solver

    companion object {
        private val DO_REGEX = "do\\(\\)".toRegex()
        private val DONT_REGEX = "don't\\(\\)".toRegex()
    }

    override fun solve(input: String): String {
        val dontPartsWithTrailingDo = DONT_REGEX.split(input)
        val dontParts = dontPartsWithTrailingDo.filterIndexed { index, _ -> index != 0 }
        val doInDontParts = dontParts.map(DO_REGEX::split).filter { it.size > 1 }.map { it.slice(1 until it.size) }
        val doParts = dontPartsWithTrailingDo[0] + doInDontParts.joinToString("") { it.joinToString("") }

        return one.solve(doParts)
    }
}