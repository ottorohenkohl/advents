package de.ottorohenkohl.riddle.twentyfour.fifteen.common

data class Position(val x: Int, val y: Int) {

    fun move(direction: Direction): Position {
        return Position(x + direction.x, y + direction.y)
    }

    fun gps(): Int {
        return 100 * y + x
    }
}