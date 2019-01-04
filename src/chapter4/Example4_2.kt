package chapter4

import java.io.Serializable

// public
// as a class element, meaning it can be seen everywhere
// as a top element, meaning it can be seen everywhere

//internal
//as a class element, meaning it can be seen within the module
//as a top element, meaning it can be seen within the module

//protected
//it can be seen in the subclass

//private
//as a class element, meaning it can be seen within the class
//as a top element, meaning it can be seen within the file

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class MyButton : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState : State {

    }
}

class Outer {

    fun getString(): String = "string"
    inner class Inner {  // in order for the instance of the inner
        fun getOuterReference(): Outer = this@Outer

        fun getOuterString(): String = this@Outer.getString()
    }
}