package de.ottorohenkohl.riddle.twentyfour.fifteen.common

enum class Direction(val x: Int, val y: Int) {
    TOP(0, -1),
    RIGHT(1, 0),
    LEFT(-1, 0),
    BOTTOM(0, 1);

    companion object {
        operator fun invoke(char: Char): Direction {
            return when (char) {
                '^' -> TOP
                '>' -> RIGHT
                'v' -> BOTTOM
                '<' -> LEFT

                else -> throw IllegalArgumentException()
            }
        }
    }
}