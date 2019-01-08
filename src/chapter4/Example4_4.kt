package chapter4

class Lock private constructor(val name: String) {

    companion object {
        fun produceLockWithDefaultName() = Lock("james")

        fun produceLock(name: String) = Lock(name)
    }
}

object demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val lock1 = Lock.produceLock("lock")
        val lock2 = Lock.produceLockWithDefaultName()
        
    }
}

class Car private constructor(val model: String) {
    companion object Creator {
        fun createCar(vin: Int) = Car(vin.toString())
    }
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Universe private constructor(val name: String) {
    companion object : JSONFactory<Universe> {
        override fun fromJSON(jsonText: String): Universe {
            return Universe("this")
        }
    }
}

class Teacher(val name: String) {
    companion object {

    }
}

fun Teacher.Companion.beatStudent(studentName: String): Boolean = studentName.startsWith("A")

object demo1 {
    @JvmStatic
    fun main(args: Array<String>) {
        Teacher.beatStudent("Adam")
    }
}
