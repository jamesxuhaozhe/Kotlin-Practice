package syntaxdemo

import java.util.*

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
    override val size: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun contains(element: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEmpty(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(): Iterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
