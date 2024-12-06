package de.ottorohenkohl.riddle.twentyfour.six.common

enum class State {

    OBSTACLE, GUARD, EMPTY;

    companion object {
        operator fun invoke(character: Char): State {
            return when (character) {
                '#' -> OBSTACLE
                '^' -> GUARD

                else -> EMPTY
            }
        }
    }
}