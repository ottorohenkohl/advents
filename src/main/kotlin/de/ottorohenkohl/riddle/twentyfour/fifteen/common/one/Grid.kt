package de.ottorohenkohl.riddle.twentyfour.fifteen.common.one

import de.ottorohenkohl.riddle.twentyfour.fifteen.common.Direction
import de.ottorohenkohl.riddle.twentyfour.fifteen.common.Position


class Grid(private val nodes: MutableMap<Position, Node>, private val movements: MutableList<Direction>) {

    private val robot get() = nodes.filter { it.value == Node.ROBOT }.keys.first()

    private fun moveNodes(position: Position, direction: Direction) {
        if (nodes.getValue(position.move(direction)).movable) moveNodes(position.move(direction), direction)
        if (nodes.getValue(position.move(direction)).replaceable) {
            nodes.replace(position.move(direction), nodes.getValue(position))
            nodes.replace(position, Node.EMPTY)
        }
    }

    private fun moveRobot() {
        moveNodes(robot, movements.removeFirst())
    }

    fun executeMovements() {
        while (movements.isNotEmpty()) {
            moveRobot()
        }
    }

    fun sumGps(): Int {
        return nodes.filter { it.value == Node.BOX }.map { it.key.gps() }.sum()
    }
}