package de.ottorohenkohl.entrypoint

import io.quarkus.logging.Log
import jakarta.enterprise.context.Dependent
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command
@Dependent
open class Entrypoint(private val downloader: Downloader, private val finder: Finder) : Runnable {

    @Option(names = ["-v", "--verbose"], defaultValue = "false")
    var verbose: Boolean? = null

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

        if (verbose == true) {
            Log.info("The input is: \n\n$input\n")
        }

        val solution = solver.solve(input)

        Log.info("The solution is: \n\n$solution\n")
    }
}