package aoc.core

data class PuzzleInput(val lines: List<String>) {
    fun nonEmptyLines(): List<String> = lines.filter { it.isNotBlank() }

    companion object {
        fun fromResource(path: String): PuzzleInput = ResourceInputLoader().load(path)
    }
}

enum class InputSource(val suffix: String) {
    PUZZLE("input"),
    EXAMPLE("example");
}

class ResourceInputLoader {
    fun load(year: Int, day: Int, source: InputSource): PuzzleInput {
        val path = buildPath(year, day, source)
        return load(path)
    }

    fun load(path: String): PuzzleInput {
        val stream = javaClass.classLoader.getResourceAsStream(path)
            ?: error("Input file $path not found on classpath")
        val content = stream.bufferedReader().readLines()
        return PuzzleInput(content)
    }

    private fun buildPath(year: Int, day: Int, source: InputSource): String {
        val dayPart = day.toString().padStart(2, '0')
        val fileName = "day${dayPart}-${source.suffix}.txt"
        return "inputs/$year/$fileName"
    }
}
