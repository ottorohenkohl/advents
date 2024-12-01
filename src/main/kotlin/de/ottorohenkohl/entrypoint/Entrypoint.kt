package de.ottorohenkohl.entrypoint

import io.quarkus.logging.Log
import jakarta.enterprise.context.Dependent
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import java.time.Duration
import java.time.LocalDateTime

@Command
@Dependent
open class Entrypoint(private val downloader: Downloader, private val finder: Finder) : Runnable {

    @Option(names = ["-d", "--day"])
    var day: Int? = null

    @Option(names = ["-p", "--part"])
    var part: Int? = null

    @Option(names = ["-y", "--year"])
    var year: Int? = null

    val parsedDay get() = day ?: throw IllegalArgumentException("No day specified")
    val parsedPart get() = part ?: throw IllegalArgumentException("No part specified")
    val parsedYear get() = year ?: throw IllegalArgumentException("No year specified")

    override fun run() {
        val solver = finder.findSolver(parsedDay, parsedPart, parsedYear)
        val input = downloader.loadInput(parsedDay, parsedYear)

        val before = LocalDateTime.now()
        val solution = solver.solve(input)
        val after = LocalDateTime.now()

        val duration = Duration.between(before, after)

        Log.info("The solution is: $solution")
        Log.info("Solution was calculated in: ${duration.toSeconds()}s and ${duration.toMillis()} ms")
    }
}