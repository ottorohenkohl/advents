package de.ottorohenkohl.riddle.twentyfour.eight.common

data class Vector(var x: Int, var y: Int) {

    constructor(first: Point, second: Point) : this(second.x - first.x, second.y - first.y)

    fun move(point: Point, times: Int = 1): Point {
        return Point(point.x + x * times, point.y + y * times)
    }

    fun inverse(): Vector {
        return Vector(x * -1, y * -1)
    }
}