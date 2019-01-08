package chapter4

import java.awt.Window

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

abstract class Shape {
    abstract fun draw()

    abstract fun getArea(): Int

    open fun getEdgeNumbers(): Int = 0
}

class Trangle : Shape() {
    override fun draw() {
        println("draw trangle")
    }

    override fun getArea(): Int {
        return 1
    }

    override fun getEdgeNumbers(): Int = 3

}

class Rectangle : Shape() {
    override fun draw() {
        println("draw rectangle")
    }

    override fun getArea(): Int {
        return 1
    }

    override fun getEdgeNumbers(): Int {
        return 4
    }
}


class ShaperProcessor(val name: String) {

    fun drawShape(shape: Shape) {
        shape.draw()
    }

    fun getShapeEdegeNumber(shape: Shape) {
        shape.getEdgeNumbers()
    }
}

object ShapeDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        val processor = ShaperProcessor("processor")
        processor.drawShape(object : Shape() {
            override fun draw() {
                println("draw unknown object")
            }

            override fun getArea(): Int {
                return 0
            }

            override fun getEdgeNumbers(): Int {
                return 0
            }
        })
    }
}

interface Being {
    fun eat()

    fun shit()

    fun drink()

    fun reProduce()

    companion object {
        fun processBeing(being: Being) {
            being.eat()
            being.drink()
            being.shit()
            being.reProduce()
        }
    }
}

class Human : Being {
    override fun eat() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shit() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun drink() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reProduce() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class Pig(val name: String) : Being {
    override fun eat() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shit() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun drink() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reProduce() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}



object BeingDemo {
    @JvmStatic
    fun main(args: Array<String>) {

        var count = 0
        Being.processBeing(object : Being {
            override fun eat() {
                count++   // you can actually access non-final variable inside this method, which is way different from Java
                println("eat some shit")
            }

            override fun shit() {
                println("shit some shit")
            }

            override fun drink() {
                println("drink something")
            }

            override fun reProduce() {
                println("produce something")
            }
        })

        val being = object : Being {
            override fun eat() {

            }

            override fun shit() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun drink() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun reProduce() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }
}