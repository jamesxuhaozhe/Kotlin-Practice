package chapter4

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus")

    fun showOff() = println("I'm focusable")
}

open class Button : Clickable, Focusable {  // open means this class
    // can be subclassed
    override fun click() {      // a method without final means it can
        // be override in the subclass
        println("I was clicked")
    }

    override fun showOff() {
        super<Clickable>.showOff()
    }

    fun disable() = println("I am disabled") // fun method in a fub
    // class is essentially final method in Java

    open fun animate() = println("animate this button") // the method
    // can be override in the subclass
}

abstract class Animated {
    abstract fun animated()

    open fun stopAnimating() {

    }

    fun animateTwice() {

    }
}

// final cannot be subclassed or overridden
// open can be subclassed or overridden
// abstract has to be subclassed or overridden
