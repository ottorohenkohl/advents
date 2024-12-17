package de.ottorohenkohl.riddle.twentyfour.fourteen

import de.ottorohenkohl.riddle.Riddle
import de.ottorohenkohl.riddle.twentyfour.fourteen.common.Floor
import de.ottorohenkohl.riddle.twentyfour.fourteen.common.Robot
import jakarta.enterprise.context.Dependent

@Dependent @Riddle(day = 14, part = 1, year = 2024)
class One : Both() {

    override fun solve(input: String): Long {
        val floor = input.rows().pairs().map { Robot(it.first, it.second) }.let { Floor(101, 103, it) }

        return evolve(100, floor).safety().toLong()
    }

    private tailrec fun evolve(times: Int, floor: Floor): Floor {
        if (times == 1) return floor.evolve()

        return evolve(times - 1, floor.evolve())
    }
}