import java.util.*

class HelloWorld {
    fun main(args: Array<String>) {
        println("Hello World")

        val question = "The Ultimate Question of Life, the Universe, and Everything"

        val answer = 42

        val question1: String = "The Ultimate Question of Life, the Universe, and Everything else"

        val answer1: Int = 48

        val yearsToCompute = 7.5e6

        val languages: ArrayList<String> = arrayListOf("Java")
        val languages1 = arrayListOf("Java")
        languages1.add("Kotlin")

    }

    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    fun max2(a: Int, b: Int): Int = if (a > b) a else b

    fun max3(a: Int, b: Int) = if (a > b) a else b

    fun whenMethod(a: Int): String =
            when(a) {
                1 -> "1"
                else -> "2"
            }
}