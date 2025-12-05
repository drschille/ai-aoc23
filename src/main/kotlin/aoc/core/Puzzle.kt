package aoc.core

interface Puzzle {
    val year: Int
    val day: Int

    fun part1(input: PuzzleInput): Any
    fun part2(input: PuzzleInput): Any
}

class PuzzleRunner(
    private val puzzles: List<Puzzle>,
    val inputLoader: ResourceInputLoader,
) {
    fun findPuzzle(year: Int, day: Int): Puzzle? = puzzles.firstOrNull { it.year == year && it.day == day }

    companion object {
        fun default(): PuzzleRunner {
            val inputLoader = ResourceInputLoader()
            val puzzles: List<Puzzle> = listOf(
                aoc.year2023.day01.Day01(),
            )
            return PuzzleRunner(puzzles, inputLoader)
        }
    }
}
