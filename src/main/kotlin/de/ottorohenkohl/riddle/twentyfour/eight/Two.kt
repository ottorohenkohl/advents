package de.ottorohenkohl.riddle.twentyfour.eight

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.twentyfour.eight.common.Point
import de.ottorohenkohl.riddle.twentyfour.eight.common.Vector
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 8, part = 2, year = 2024)
class Two : Both() {

    override fun solve(input: String): Long {
        val points = input.rows().columns().points().grouped()
        val maximum = if (input.rows().size > input.rows().columns().size) input.rows().size else input.rows().columns().size
        val antinodes = points.mapValues { it.value.cartesian { first, second -> antinodes(first, second, maximum) }.flatten() }

        return antinodes.map { it.value }.flatten().toSet().count { it.inbounds(input.rows().columns().size, input.rows().size) }.toLong()
    }

    private fun antinodes(first: Point, second: Point, number: Int): List<Point> {
        return List(number) { Vector(first, second).inverse().move(first, it) }
    }
}