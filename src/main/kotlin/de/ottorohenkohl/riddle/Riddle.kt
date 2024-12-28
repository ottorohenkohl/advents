package de.ottorohenkohl.riddle

import jakarta.enterprise.context.Dependent
import jakarta.inject.Qualifier

@Dependent
@Qualifier
annotation class Riddle(val day: Int, val part: Int, val year: Int)