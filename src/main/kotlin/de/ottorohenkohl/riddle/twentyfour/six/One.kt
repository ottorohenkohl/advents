package de.ottorohenkohl.riddle.twentyfour.six

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.twentyfour.six.common.Direction
import de.ottorohenkohl.riddle.twentyfour.six.common.Position
import de.ottorohenkohl.riddle.twentyfour.six.common.State.OBSTACLE
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 6, part = 1, year = 2024)
class One : Both() {

    lateinit var visited: MutableList<Pair<Position, Direction>>

    override fun solve(input: String): String {
        val area = input.rows().columns().positions()

        visited = mutableListOf(area.guard() to Direction.NORTH)

        while (true) {
            if (area[visited.last().direction().next(visited.last().position())] == OBSTACLE) {
                visited.add(visited.last().position() to visited.last().direction().turn())

                continue
            }

            val next = visited.last().direction().next(visited.last().position()) to visited.last().direction()

            if (area.containsKey(next.position()).not()) break
            if (visited.contains(next)) throw IllegalStateException()

            visited.add(next)
        }

        return visited.map { it.first }.toSet().size.toString()
    }

    private fun Pair<Position, Direction>.position(): Position {
        return first
    }

    private fun Pair<Position, Direction>.direction(): Direction {
        return second
    }
}