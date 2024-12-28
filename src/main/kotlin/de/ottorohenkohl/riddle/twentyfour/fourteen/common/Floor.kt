package de.ottorohenkohl.riddle.twentyfour.fourteen.common

import kotlin.math.absoluteValue

data class Floor(val width: Int, val height: Int, val robots: List<Robot>) {

    private val firstQuadrant get() = Floor(width / 2, height / 2, robots.filter { it.pos.x > width / 2 + 1 && it.pos.y <= height / 2 })
    private val secondQuadrant get() = Floor(width / 2, height / 2, robots.filter { it.pos.x <= width / 2 && it.pos.y <= height / 2 })
    private val thirdQuadrant get() = Floor(width / 2, height / 2, robots.filter { it.pos.x <= width / 2 && it.pos.y > height / 2 + 1 })
    private val fourthQuadrant get() = Floor(width / 2, height / 2, robots.filter { it.pos.x > width / 2 + 1 && it.pos.y > height / 2 + 1 })

    fun evolve(): Floor {
        return robots.map {
            var newX = it.pos.x + it.vel.x
            var newY = it.pos.y + it.vel.y

            if (newX > width) newX -= width
            if (newY > height) newY -= height
            if (newX < 1) newX = width - newX.absoluteValue
            if (newY < 1) newY = height - newY.absoluteValue

            return@map it.copy(pos = Position(newX, newY))
        }.let { this.copy(robots = it) }
    }

    fun safety(): Int {
        return firstQuadrant.robots.size * secondQuadrant.robots.size * thirdQuadrant.robots.size * fourthQuadrant.robots.size
    }
}