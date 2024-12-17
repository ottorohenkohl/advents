package de.ottorohenkohl.riddle.twentyfour.fourteen

import de.ottorohenkohl.riddle.Solver
import de.ottorohenkohl.riddle.twentyfour.fourteen.common.Position
import de.ottorohenkohl.riddle.twentyfour.fourteen.common.Velocity

abstract class Both : Solver {

    fun String.rows(): List<String> {
        return this.split("\n")
    }

    fun List<String>.pairs(): List<Pair<Position, Velocity>> {
        return map { it.split(" ") }.map { it.map { value -> value.split("=")[1].split(",") } }.map { Position(it[0][0].toInt() + 1, it[0][1].toInt() + 1) to Velocity(it[1][0].toInt(), it[1][1].toInt()) }
    }
}