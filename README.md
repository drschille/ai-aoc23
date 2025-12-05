# Advent of Code Kotlin Workspace

This repository is a Kotlin/JVM Gradle project for solving Advent of Code puzzles. Each puzzle day is registered as its own `Puzzle` implementation so solutions can be executed individually while sharing supporting utilities.

## Project layout
- `src/main/kotlin/aoc` – application entrypoint (`App.kt`).
- `src/main/kotlin/aoc/core` – shared puzzle abstractions and input loading helpers.
- `src/main/kotlin/aoc/year2023` – solutions for the 2023 event, organized by day (e.g., `day01`).
- `src/main/resources/inputs` – puzzle and example data files, grouped by year and day.
- `src/test/kotlin` – test suites that validate solutions against the provided example data.

## Running a puzzle
Use Gradle to execute a specific puzzle. The `--example` flag loads the sample input instead of the puzzle input.

```bash
./gradlew run --args="2023 1"         # uses inputs/2023/day01-input.txt
./gradlew run --args="2023 1 --example"  # uses inputs/2023/day01-example.txt
```

## Adding a new day
1. Create a new package under `src/main/kotlin/aoc/year<YEAR>/day<DAY>`.
2. Implement the `Puzzle` interface.
3. Register the new class in `PuzzleRunner.default()`.
4. Place input files under `src/main/resources/inputs/<YEAR>/` following the `dayDD-input.txt` and `dayDD-example.txt` naming pattern.
5. Add tests under `src/test/kotlin` using the example data to verify both parts.
