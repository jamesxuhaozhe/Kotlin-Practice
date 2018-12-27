package syntaxdemo

open class View {
    open fun click() = println("I am a view")
}

class Button: View() {
    override fun click() = println("I am a button")
}