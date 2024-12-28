package de.ottorohenkohl.riddle.twentyfour.fifteen

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.twentyfour.fifteen.common.Position
import de.ottorohenkohl.riddle.twentyfour.fifteen.common.one.Grid
import de.ottorohenkohl.riddle.twentyfour.fifteen.common.one.Node
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 15, part = 1, year = 2024)
class One : Both() {

    private fun String.nodes(): MutableMap<Position, Node> {
        return split("\n\n")[0].split("\n").mapIndexed {y, row -> row.toCharArray().mapIndexed { x, char -> Position(x, y) to Node(char) }}.flatten().toMap().toMutableMap()
    }

    override fun solve(input: String): Long {
        val grid = Grid(input.nodes(), input.movements())

        grid.executeMovements()

        return grid.sumGps().toLong()
    }
}