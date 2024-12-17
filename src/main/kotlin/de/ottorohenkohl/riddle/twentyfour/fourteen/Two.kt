package de.ottorohenkohl.riddle.twentyfour.fourteen

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.twentyfour.fourteen.common.Floor
import de.ottorohenkohl.riddle.twentyfour.fourteen.common.Robot
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 14, part = 2, year = 2024)
class Two : Both() {

    override fun solve(input: String): Long {
        val floors = input.rows().pairs().map { Robot(it.first, it.second) }.let { Floor(101, 103, it) }.let { mutableListOf(it) }

        picture(100000, floors)

        val safeties = floors.map { it.safety() }

        return safeties.indexOf(safeties.min()).toLong()
    }

    private tailrec fun picture(range: Int, floors: MutableList<Floor>) {
        floors.add(floors.last().evolve())

        if (range == 1) return

        return picture(range - 1, floors)
    }
}