package aoc.year2023.day01

import aoc.core.Puzzle
import aoc.core.PuzzleInput

class Day01 : Puzzle {
    override val year: Int = 2023
    override val day: Int = 1

    override fun part1(input: PuzzleInput): Int = input.nonEmptyLines().sumOf { calibrationValue(it, includeWords = false) }

    override fun part2(input: PuzzleInput): Int = input.nonEmptyLines().sumOf { calibrationValue(it, includeWords = true) }

    private fun calibrationValue(line: String, includeWords: Boolean): Int {
        val digits = mutableListOf<Int>()
        for (index in line.indices) {
            val char = line[index]
            if (char.isDigit()) {
                digits.add(char.digitToInt())
            }
            if (includeWords) {
                wordDigitAt(line, index)?.let { digits.add(it) }
            }
        }
        val first = digits.first()
        val last = digits.last()
        return first * 10 + last
    }

    private fun wordDigitAt(value: String, index: Int): Int? {
        for ((word, digit) in wordToDigit) {
            if (value.startsWith(word, index)) {
                return digit
            }
        }
        return null
    }

    companion object {
        private val wordToDigit = mapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,
        )
    }
}
