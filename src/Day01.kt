fun main() {
    fun part1(input: List<Int>): Int {
        println(input.size)
        return input.windowed(2).count { (first, second) ->
            second > first
        }
    }

    fun part2(input: List<Int>): Int {
        return input.windowed(4).count { it[0]<it[3] }
    }

    // test if implementation meets criteria from the description, like:
    // val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)
    val input = readInput("aoc-1")
    println(part2(input))
    //println(part2(input))
}
