package aoc

import aoc.core.PuzzleRunner
import aoc.core.InputSource

fun main(args: Array<String>) {
    val options = CommandLineOptions.from(args)
    if (options == null) {
        CommandLineOptions.printUsage()
        return
    }

    val runner = PuzzleRunner.default()
    val puzzle = runner.findPuzzle(options.year, options.day)
    if (puzzle == null) {
        println("No puzzle registered for ${options.year} day ${options.day}")
        return
    }

    val input = runner.inputLoader.load(options.year, options.day, options.source)
    val result1 = puzzle.part1(input)
    val result2 = puzzle.part2(input)

    println("[${options.year} Day ${options.day}] Part 1 => $result1")
    println("[${options.year} Day ${options.day}] Part 2 => $result2")
}

data class CommandLineOptions(
    val year: Int,
    val day: Int,
    val source: InputSource,
) {
    companion object {
        fun from(args: Array<String>): CommandLineOptions? {
            if (args.size !in 2..3) return null
            val year = args[0].toIntOrNull() ?: return null
            val day = args[1].toIntOrNull() ?: return null
            val source = if (args.getOrNull(2) == "--example") InputSource.EXAMPLE else InputSource.PUZZLE
            return CommandLineOptions(year, day, source)
        }

        fun printUsage() {
            println("Usage: ./gradlew run --args=\"<year> <day> [--example]\"")
            println("The optional --example flag loads the sample data instead of the puzzle input.")
        }
    }
}
