package syntaxdemo

import java.lang.IllegalArgumentException
import kotlin.random.Random

class Demo {
    fun main(args: Array<String>) {
        if (args.size > 0) {
            println("Hellow ${args[0]}")
        }

        println("Hello ${if (args.size > 0) args[0] else "haha"}")

        val person = Person("James")

        val worker = Worker("James", true)
        println(worker.name)
        println(worker.isMarried)

        val rectangle = Rectangle(10, 10)
        println(rectangle.isSquare)

        val rectangle1 = Rectangle(12, 13)
        println(rectangle1.isSquare)

        println(createRandomRectangle().isSquare)

        println(eval1(Expr.Sum(Expr.Num(1), Expr.Num(2))))

    }
}

class Person(val name: String)

class Worker(
    val name: String,
    val isMarried: Boolean
)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }

}

fun createRandomRectangle(): Rectangle {
    val random = Random(100)
    return Rectangle(random.nextInt(), random.nextInt())

}

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Color1(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color1) =
        when(color) {
            Color1.RED -> "red"
            Color1.BLUE -> "blue"
            else -> "other"
        }

fun getWarmth(color: Color1) =
        when(color) {
            Color1.RED, Color1.ORANGE, Color1.YELLOW -> "warm"
            Color1.GREEN -> "neutral"
            Color1.BLUE, Color1.INDIGO, Color1.VIOLET -> "cold"
        }

fun mix(color1: Color1, color2: Color1) =
        when(setOf(color1, color2)) {
            setOf(Color1.RED, Color1.YELLOW) -> Color1.ORANGE
            setOf(Color1.YELLOW, Color1.BLUE) -> Color1.GREEN
            setOf(Color1.BLUE, Color1.VIOLET) -> Color1.INDIGO
            else-> throw Exception("Dirty color")
        }

fun mixOptimized(color1: Color1, color2: Color1) =
        when {
            (color1 == Color1.RED && color2 == Color1.YELLOW) ||
                    (color2 == Color1.RED && color1 == Color1.YELLOW)
            -> Color1.ORANGE
            else -> throw Exception("dirty color")
        }

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}


fun eval1(e: Expr): Int {
    if (e is Expr.Num) {
        val n = e as Expr.Num
        return n.value
    }
    if (e is Expr.Sum) {
        return eval1(e.right) + eval1(e.left)
    }
    throw IllegalArgumentException("Unkown expression")
}

fun eval2(e: Expr): Int {
    if (e is Expr.Num) {
        return e.value
    }
    if (e is Expr.Sum) {
        return eval1(e.right) + eval1(e.left)
    }
    throw IllegalArgumentException("Unkown expression")
}

fun evalWithLogging(e: Expr): Int =
    when(e) {
        is Expr.Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Expr.Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
    }











































