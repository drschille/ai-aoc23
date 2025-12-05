package aoc.year2023.day01

import aoc.core.PuzzleInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    private val puzzle = Day01()

    @Test
    fun `part 1 matches calibration sum for sample`() {
        val input = PuzzleInput.fromResource("inputs/2023/day01-example.txt")
        assertEquals(142, puzzle.part1(input))
    }

    @Test
    fun `part 2 matches calibration sum with embedded number words`() {
        val input = PuzzleInput.fromResource("inputs/2023/day01-example-words.txt")
        assertEquals(281, puzzle.part2(input))
    }
}
