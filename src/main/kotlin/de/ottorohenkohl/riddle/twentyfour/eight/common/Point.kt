package de.ottorohenkohl.riddle.twentyfour.eight.common

data class Point(var x: Int, var y: Int) {

    fun inbounds(height: Int, width: Int): Boolean {
        return x in 0..<width && y in 0..<height
    }
}