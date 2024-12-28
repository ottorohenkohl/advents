package de.ottorohenkohl.riddle.twentyfour.three

import de.ottorohenkohl.riddle.Solver

abstract class Both : Solver {

    companion object {
        val MUL_REGEX = "mul\\((\\d+),(\\d+)\\)".toRegex()
    }
}