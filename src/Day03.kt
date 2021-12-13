import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Double {
        val listZero = MutableList(input[0].length) { 0 }
        val listOne = MutableList(input[0].length) { 0 }
        for (item in input) {
            item.withIndex().forEach {
                when (it.value.digitToInt()) {
                    0 -> listZero[it.index] += 1
                    1 -> listOne[it.index] += 1
                }
            }
        }
        var gamma = 0.0
        var epsilon = 0.0
        for (index in 0 until listZero.size){
            if (listZero[index] > listOne[index]) {
                epsilon += 2.0.pow(listZero.size-1 - index)
            }
            else {
                gamma += 2.0.pow(listZero.size-1 - index)
            }
        }
        return gamma * epsilon
    }

    fun part2(input: List<String>): Double {
        val listZero = MutableList(input[0].length) { 0 }
        val listOne = MutableList(input[0].length) { 0 }
        for (item in input) {
            item.withIndex().forEach {
                when (it.value.digitToInt()) {
                    0 -> listZero[it.index] += 1
                    1 -> listOne[it.index] += 1
                }
            }
        }
        var oxygenGen = input
        var co2Scrubber = input
        for (index in 0 until listZero.size) {
            when {
                listZero[index] > listOne[index] -> {
                    if (oxygenGen.size > 1) oxygenGen = oxygenGen.filter { it[index] == '0' }
                    if (co2Scrubber.size > 1) co2Scrubber = co2Scrubber.filter { it[index] == '1' }
                }
                listZero[index] == listOne[index] -> {
                    if (oxygenGen.size > 1) oxygenGen = oxygenGen.filter { it[index] == '1' }
                    if (co2Scrubber.size > 1) co2Scrubber = co2Scrubber.filter { it[index] == '0'  }
                }
                else -> {
                    if (oxygenGen.size > 1) oxygenGen = oxygenGen.filter { it[index] == '1'}
                    if (co2Scrubber.size > 1) co2Scrubber = co2Scrubber.filter { it[index] == '0' }
                }
            }
        }

        var o2 = 0.0
        var co2 = 0.0
        val o2Binary = oxygenGen[0]
        val co2Binary = co2Scrubber[0]

        for (i in o2Binary.indices) {
            o2 += o2Binary[i].digitToInt() * 2.0.pow(o2Binary.length-1 - i)
            co2 += co2Binary[i].digitToInt() * 2.0.pow(co2Binary.length-1 - i)
        }

        println("o2 is $o2, co2 is $co2")

        return o2*co2
    }

    val input = readInputAsString("aoc-3")
    //println(part1(input))
    println(part2(readInputSorted("aoc-3")))
}