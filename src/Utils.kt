import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("$name.txt").readLines().map { it.toInt() }

fun readInputAsString(name: String) = File("$name.txt").readLines()

fun readInputSorted(name: String) = File("$name.txt").readLines().sorted()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
