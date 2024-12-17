package de.ottorohenkohl.riddle.twentyfour.fifteen

import de.ottorohenkohl.riddle.Solver
import de.ottorohenkohl.riddle.twentyfour.fifteen.common.Direction

abstract class Both : Solver {

    fun String.movements(): MutableList<Direction> {
        return split("\n\n")[1].replace("\n", "").toCharArray().map { Direction(it) }.toMutableList()
    }
}