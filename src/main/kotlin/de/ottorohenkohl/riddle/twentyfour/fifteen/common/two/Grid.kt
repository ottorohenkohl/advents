package de.ottorohenkohl.riddle.twentyfour.fifteen.common.two

import de.ottorohenkohl.riddle.twentyfour.fifteen.common.Direction
import de.ottorohenkohl.riddle.twentyfour.fifteen.common.Position


class Grid(private var nodes: MutableMap<Position, Node>, private val movements: MutableList<Direction>) {

    private val robot get() = nodes.filter { it.value == Node.ROBOT }.keys.first()

    private fun moveNodes(position: Position, direction: Direction): Boolean {
        if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            if (nodes.getValue(position.move(direction)).movable) moveNodes(position.move(direction), direction)
        } else {
            if (nodes.getValue(position.move(direction)) == Node.BOX_LEFT && moveNodes(position.move(direction).move(
                    Direction.RIGHT
                ), direction)) moveNodes(position.move(direction), direction)
            if (nodes.getValue(position.move(direction)) == Node.BOX_RIGHT && moveNodes(position.move(direction).move(
                    Direction.LEFT
                ), direction)) moveNodes(position.move(direction), direction)
        }

        if (nodes.getValue(position.move(direction)).replaceable) {
            nodes.replace(position.move(direction), nodes.getValue(position))
            nodes.replace(position, Node.EMPTY)

            return true
        }

        return false
    }

    private fun moveRobot() {
        nodes.toMutableMap().let { if (moveNodes(robot, movements.removeFirst()).not()) nodes = it }
    }

    fun executeMovements() {
        while (movements.isNotEmpty()) {
            moveRobot()
        }
    }

    fun sumGps(): Int {
        return nodes.filter { it.value == Node.BOX_LEFT }.map { it.key.gps() }.sum()
    }
}