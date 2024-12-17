package de.ottorohenkohl.riddle.twentyfour.fifteen

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.twentyfour.fifteen.common.two.Grid
import de.ottorohenkohl.riddle.twentyfour.fifteen.common.two.Node
import de.ottorohenkohl.riddle.twentyfour.fifteen.common.Position
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 15, part = 2, year = 2024)
class Two : Both() {

    private fun String.nodes(): MutableMap<Position, Node> {
        return split("\n\n")[0].split("\n").mapIndexed {y, row -> row.replace("#", "##").replace("O", "[]").replace(".", "..").replace("@", "@.").toCharArray().mapIndexed { x, char -> Position(x, y) to Node(char) }}.flatten().toMap().toMutableMap()
    }

    override fun solve(input: String): Long {
        val grid = Grid(input.nodes(), input.movements())

        grid.executeMovements()

        return grid.sumGps().toLong()
    }
}