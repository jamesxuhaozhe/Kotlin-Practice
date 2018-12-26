package syntaxdemo

import java.util.*


fun main(args: Array<String>) {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        binaryReps[c] = Integer.toBinaryString(c.toInt())
    }

    for ((key, value) in binaryReps) {
        println("key: $key value: $value")
    }
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "Fizz Buzz "
    i % 5 == 0 -> "Fizz "
    i % 3 == 0 -> "Buzz "
    else -> "$i "
}
