package de.ottorohenkohl.entrypoint

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.Solver
import jakarta.enterprise.context.Dependent
import jakarta.enterprise.inject.Any
import jakarta.enterprise.inject.Instance

@Dependent
open class Finder(@Any private val solvers: Instance<Solver>) {

    fun findSolver(day: Int, part: Int, year: Int): Solver {
        val qualifier = Riddle(day, part, year)
        val found = solvers.select(qualifier)

        return found.get()
    }
}