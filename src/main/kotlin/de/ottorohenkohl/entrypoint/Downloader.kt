package de.ottorohenkohl.entrypoint

import jakarta.enterprise.context.Dependent
import jakarta.ws.rs.client.ClientBuilder
import org.eclipse.microprofile.config.inject.ConfigProperty

@Dependent
class Downloader {

    @ConfigProperty(name = "aoc.session")
    lateinit var session: String

    fun loadInput(day: Int, year: Int): String {
        val target = ClientBuilder.newClient().target("https://adventofcode.com/$year/day/$day/input")

        return target.request().cookie("session", session).get(String::class.java).trim()
    }
}