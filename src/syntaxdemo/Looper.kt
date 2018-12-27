package syntaxdemo

import strings.join
import strings.lastChar
import java.io.BufferedReader
import java.lang.NumberFormatException
import java.util.*
import kotlin.text.StringBuilder


fun main(args: Array<String>) {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    println(listOf(*args, "1"))

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        binaryReps[c] = Integer.toBinaryString(c.toInt())
    }

    for ((key, value) in binaryReps) {
        println("key: $key value: $value")
    }

    val list = arrayListOf(1, 2, 3, 4, 5, 6, 7)
    for ((index, element) in list.withIndex()) {
        println("$index : $element")
    }
    println("Kotlin" in setOf("Java", "Scala"))

    val percentage = 100
    if (percentage !in 0..100) {
        throw IllegalArgumentException("it is impossible")
    }
    var percent = if (percentage in 0..100) percentage else throw IllegalArgumentException("it is crazy")

    val set = hashSetOf(1, 2, 3, 4, 5)
    val list1 = arrayListOf(1, 2, 3, 6)
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")
    println(set.javaClass)
    println(list1.javaClass)
    println(map.javaClass)

    val strings = listOf(1, 2, 3, 4, 5, 6)
    println(strings.last())

    val set1 = setOf(1, 2, 3, 5, 6)
    println(set1.max())

    val list2 = listOf(1, 2, 3, 4, 55, 5)
    println(joinToString(list2, ";", "(", ")"))

    println(joinToStringV1(list2))

    println(joinToStringV1(list2, separator = "?"))

    println("Kotlin".lastChar())

    println(listOf("one", "two", "three").join(" "))

    val view: View = Button()
    view.click()

    val stuff = "stuff"
    println(stuff.lastChar)

    val sb = StringBuilder("sb")
    println(sb.lastChar)
    sb.lastChar = '!'

    val (number, name) = 1 to "one"

    println("12.345-6.A".split("\\.|-".toRegex()))

    println("12.345-6.A".split(".", "-"))

    val path = "/Users/yole/kotlin-book/Chapter.doc"

    parsePath(path)

    parsePath1(path)

}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "Fizz Buzz "
    i % 5 == 0 -> "Fizz "
    i % 3 == 0 -> "Buzz "
    else -> "$i "
}

// in function so to check the range
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z' -> "It's a char"
    else -> "I don't know"
}

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun readNumer(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }
    println(number)
}

fun readNumberV1(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}

fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun <T> joinToStringV1(collection: Collection<T>, separator: String = ":", prefix: String = "(", postfix: String = ")"): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("$directory $fileName $extension")
}

fun parsePath1(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("$directory $filename $extension")
    }
}

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw java.lang.IllegalArgumentException("Can't save user: ${user.id} empty $fieldName")
        }
    }
    validate(user, user.name, "name")
    validate(user, user.address, "address")
}




