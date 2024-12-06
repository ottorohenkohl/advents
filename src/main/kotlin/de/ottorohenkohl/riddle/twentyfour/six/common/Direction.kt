package de.ottorohenkohl.riddle.twentyfour.six.common

enum class Direction {

    NORTH, EAST, SOUTH, WEST;

    fun next(position: Position): Position {
        return when (this) {
            NORTH -> Position(position.x, position.y - 1)
            EAST -> Position(position.x + 1, position.y)
            SOUTH -> Position(position.x, position.y + 1)
            WEST -> Position(position.x - 1, position.y)
        }
    }

    fun turn(): Direction {
        return when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }
}