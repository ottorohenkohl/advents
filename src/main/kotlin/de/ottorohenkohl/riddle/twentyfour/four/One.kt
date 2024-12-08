package de.ottorohenkohl.riddle.twentyfour.four

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 4, part = 1, year = 2024)
class One : Both() {

    companion object {
        private val HORIZONTAL_RIGHT = "XMAS".toRegex()
        private val VERTICAL_DOWN = "(?=(X.{$LINE_LENGTH}M.{$LINE_LENGTH}A.{$LINE_LENGTH}S))".toRegex(option = RegexOption.DOT_MATCHES_ALL)
        private val DIAGONAL_FORWARD = "(?=(X.{${LINE_LENGTH + 1}}M.{${LINE_LENGTH + 1}}A.{${LINE_LENGTH + 1}}S))".toRegex(option = RegexOption.DOT_MATCHES_ALL)
        private val DIAGONAL_BACKWARD = "(?=(X.{${LINE_LENGTH - 1}}M.{${LINE_LENGTH - 1}}A.{${LINE_LENGTH - 1}}S))".toRegex(option = RegexOption.DOT_MATCHES_ALL)
    }

    override fun solve(input: String): Long {
        return (once(input) + once(input.reversed())).toLong()
    }

    private fun once(input: String): Int {
        return (HORIZONTAL_RIGHT.findAll(input) + VERTICAL_DOWN.findAll(input) + DIAGONAL_FORWARD.findAll(input) +  DIAGONAL_BACKWARD.findAll(input)).count()
    }
}