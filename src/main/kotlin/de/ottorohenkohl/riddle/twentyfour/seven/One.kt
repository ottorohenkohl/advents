package de.ottorohenkohl.riddle.twentyfour.seven

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent
import java.util.function.BiFunction

@Dependent @Riddle(day = 7, part = 1, year = 2024)
class One : Both() {

    override fun solve(input: String): String {
        val addition = BiFunction<Long, Long, Long> { first, second -> first + second }
        val multiplication = BiFunction<Long, Long, Long> { first, second -> first * second }

        return input.rows().equations().filter { check(it.first, it.second, listOf(addition, multiplication)) }.sumOf { it.first }.toString()
    }
}