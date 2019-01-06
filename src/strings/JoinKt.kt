@file:JvmName("StringFunctions")

package strings

import syntaxdemo.Button
import syntaxdemo.View

var opCount = 0

fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {
    opCount++
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

fun getOperationCount(): Int = opCount

fun String.lastChar(): Char = this.get(this.length -1)



fun String.lastChar1(): Char {
    return this.get(this.length - 1)
}

fun <T> Collection<T>.joinToStringV1(separator: String = "O", prefix: String = "#", postfix: String = "#"): String {
    val result = java.lang.StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(separator: String = ", ", prefix: String = "", postfix: String = "") = joinToStringV1(separator, prefix, postfix)

fun View.click() = println("this is a view from outside")
fun Button.click() = println("this is a button from outside")

val String.lastChar: Char get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

infix fun Any.to(other: Any)= Pair(this, other)

