package de.ottorohenkohl.riddle.twentyfour.six

import de.ottorohenkohl.riddle.Solver
import de.ottorohenkohl.riddle.twentyfour.six.common.Position
import de.ottorohenkohl.riddle.twentyfour.six.common.State

abstract class Both : Solver {

    protected fun String.rows(): List<String> {
        return split("\n")
    }

    protected fun String.width(): Int {
        return (split("\n").getOrNull(0)?.length ?: 0) + 1
    }

    protected fun List<String>.columns(): List<List<Char>> {
        return map { it.toCharArray().toList() }
    }

    protected fun List<List<Char>>.positions(): Map<Position, State> {
        return mapIndexed { y, row -> row.toCharArray().mapIndexed { x, column -> Position(x, y) to State(column) } }.flatten().toMap()
    }

    protected fun Map<Position, State>.guard(): Position {
        return filterValues(State.GUARD::equals).keys.first()
    }
}