package de.ottorohenkohl.riddle.twentyfour.four

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 4, part = 2, year = 2024)
class Two : Both() {

    companion object {
        private val S_ABOVE = "(?=(S.S.{${LINE_LENGTH - 1}}A.{${LINE_LENGTH - 1}}M.M))".toRegex(option = RegexOption.DOT_MATCHES_ALL)
        private val S_LEFT = "(?=(S.M.{${LINE_LENGTH - 1}}A.{${LINE_LENGTH - 1}}S.M))".toRegex(option = RegexOption.DOT_MATCHES_ALL)
    }

    override fun solve(input: String): String {
        return (once(input) + once(input.reversed())).toString()
    }

    private fun once(input: String): Int {
        return (S_ABOVE.findAll(input) + S_LEFT.findAll(input)).count()
    }
}