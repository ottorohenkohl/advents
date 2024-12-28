package de.ottorohenkohl.riddle.twentyfour.seven

import de.ottorohenkohl.riddle.Riddle
import jakarta.enterprise.context.Dependent
import java.util.function.BiFunction

@Dependent @Riddle(day = 7, part = 2, year = 2024)
class Two : Both() {

    override fun solve(input: String): Long {
        val addition = BiFunction<Long, Long, Long> { first, second -> first + second }
        val multiplication = BiFunction<Long, Long, Long> { first, second -> first * second }
        val concatenation = BiFunction<Long, Long, Long> { first, second -> "$first$second".toLong() }

        return input.rows().equations().filter { check(it.first, it.second, listOf(addition, multiplication, concatenation)) }.sumOf { it.first }
    }
}
