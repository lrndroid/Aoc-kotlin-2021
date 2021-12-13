
const val FORWARD = "forward"
const val DOWN = "down"
const val UP = "up"

fun main() {
    fun part1(input: List<Pair<String, Int>>): Int {
        var horizantal = 0
        var depth = 0
        for (item in input) {
            when (item.first) {
                FORWARD -> horizantal += item.second
                UP -> depth -= item.second
                DOWN -> depth += item.second
            }
        }
        return horizantal * depth
    }

    fun part2(input: List<Pair<String, Int>>): Int {
        var horizantal = 0
        var depth = 0
        var aim = 0

        for (item in input) {
            when (item.first) {
                FORWARD -> {
                    horizantal += item.second
                    depth += (aim * item.second)
                }
                UP -> {
                    aim -= item.second
                }
                DOWN -> {
                    aim += item.second
                }
            }
        }

        return horizantal * depth
    }

    val input = readInputAsString("aoc-2").map {
        Pair(it.split(" ")[0], it.split(" ")[1].toInt())
    }
    println(input)
    println(part1(input))
    println(part2(input))
}