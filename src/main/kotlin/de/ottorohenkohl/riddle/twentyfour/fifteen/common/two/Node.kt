package de.ottorohenkohl.riddle.twentyfour.fifteen.common.two

enum class Node(val movable: Boolean, val replaceable: Boolean) {
    BOX_LEFT(true, false),
    BOX_RIGHT(true, false),
    ROBOT(true, false),
    WALL(false, false),
    EMPTY(false, true);

    companion object {
        operator fun invoke(char: Char): Node {
            return when (char) {
                '[' -> BOX_LEFT
                ']' -> BOX_RIGHT
                '@' -> ROBOT
                '#' -> WALL
                '.' -> EMPTY

                else -> throw IllegalArgumentException()
            }
        }
    }
}