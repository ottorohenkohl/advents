package de.ottorohenkohl.riddle.twentyfour.fifteen.common.one

enum class Node(val movable: Boolean, val replaceable: Boolean) {
    BOX(true, false),
    ROBOT(true, false),
    WALL(false, false),
    EMPTY(false, true);

    companion object {
        operator fun invoke(char: Char): Node {
            return when (char) {
                'O' -> BOX
                '@' -> ROBOT
                '#' -> WALL
                '.' -> EMPTY

                else -> throw IllegalArgumentException()
            }
        }
    }
}