package de.ottorohenkohl.riddle.twentyfour.eight

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.twentyfour.eight.common.Vector
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 8, part = 1, year = 2024)
class One : Both() {

    override fun solve(input: String): Long {
        val points = input.rows().columns().points().grouped()
        val antinodes = points.mapValues { it.value.cartesian { first, second -> Vector(first, second).inverse().move(first) } }

        return antinodes.map { it.value }.flatten().toSet().count { it.inbounds(input.rows().columns().size, input.rows().size) }.toLong()
    }
}