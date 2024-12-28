package de.ottorohenkohl.riddle

import jakarta.inject.Qualifier

@Qualifier
annotation class Riddle(val day: Int, val part: Int, val year: Int)