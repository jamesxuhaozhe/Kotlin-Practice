package syntaxdemo

import java.io.File
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

open class View {
    open fun click() = println("I am a view")
}

class Button: View() {
    override fun click() = println("I am a button")
}

class Client1(val name: String, val age: Int) {
    override fun hashCode(): Int {
        return name.hashCode() * 31 + age
    }

    fun copy(name: String, age: Int = this.age) = Client2(name, age)
}

data class Client2(val name: String, val postcode: Int) {

}

object Play {
    @JvmStatic
    fun main(args: Array<String>) {
        val client1 = Client2("James", 29)
        val client2 = Client2("James", 29)

        if (client1.equals(client2)) println("equal") else println("not equal!")
    }
}

class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()
    override val size: Int
        get() = innerList.size

    override fun contains(element: T): Boolean {
        return innerList.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return innerList.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return innerList.isEmpty()
    }

    override fun iterator(): Iterator<T> {
        return innerList.iterator()
    }

}

class DelegatingCollection1<T>(val innerList: Collection<T> = ArrayList<T>()): Collection<T> by innerList {}

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            //no-op
        }
    }
}

object helper {
    @JvmStatic
    fun main(args: Array<String>) {
        Payroll.allEmployees.add(Person("James"))
        Payroll.allEmployees.add(Person("Adam"))
        Payroll.calculateSalary()

        val persons = listOf(Student("james", 1), Student("Adam", 2))
        persons.sortedWith(Student.StudentComparator)
    }
}

data class Student(val name: String, val id: Int) {
    object StudentComparator : Comparator<Student> {
        override fun compare(o1: Student, o2: Student): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

class Point(val x: Int, val y:Int) {
    operator fun plus(point: Point): Point {
        return Point(x + point.x, y + point.y)
    }

    operator fun minus(point: Point): Point {
        return Point(x - point.x, y - point.y)
    }

    operator fun times(i: Int): Point {
        return Point(x * i, y * i)
    }

    operator fun div(i: Int): Point {
        return Point((x / i).toInt(), (y / i).toInt())
    }
}

object DemoClass1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val point = Point(1, 2)
        val point2 = point.plus(Point(4, 5))

        val point3 = point.times(4)

        var point4 = Point(1, 5)
        point4 += Point(4, 6)

        var point6: Point? = null
        if (point6 != null) {
            point6.y
            point6.x
        }
    }
}

class MyClass(val number: Int, val number2: Int) {
    private var point: Point? = null

    private fun initPoint() {
        point = Point(1, 2)
    }

    fun getPoint() {
        initPoint()
        if (point != null) {
            point?.x
            point?.y
        }
    }
}

class DemoClass(val number: String, val number1: Int) {

    fun getPoint() {
        val point: Point = Point(1, 2)

    }
}

