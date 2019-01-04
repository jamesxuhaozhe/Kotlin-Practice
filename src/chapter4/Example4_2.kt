package chapter4

import java.io.Serializable
import java.util.jar.Attributes
import javax.naming.Context

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

class User constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

class User1(_age: Int) {
    val age = _age
}

open class User2(val nickname: String)

class User3(val nickname: String, val isMale: Boolean = true)

val user = User("James")

class TwitterUser(nickname: String) : User2(nickname) {

}

open class Button1  // you can declare a class just like this, it doesn't do shit 

class RadioButton : Button1()    // a subclass that doesn't have its own
// ctor, you need to put () in the superclass


class Secretive private constructor() {

}

open class MyView {
    constructor(ctx: Context) {
        // no-op
    }

    constructor(ctx: Context, attr: Attributes) {
        
    }
}

class MyButton1 : MyView {
    constructor(ctx: Context): super(ctx) {

    }
    constructor(ctx: Context, attr: Attributes): super(ctx, attr) {
        
    }
}

class Bird {
    constructor(sex: String, age: Int)

    constructor(sex: String): this(sex, 1) {

    }
}

interface IUser {
    val nickname: String
}

class PrivateUser(override val nickname: String) : IUser

class SubscribingUser(val email: String) : IUser {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : IUser {
    override val nickname: String = getFacebookName(accountId)

    fun getFacebookName(accountId: Int): String = "nickname"
}

val privateUser = PrivateUser("James")

interface IUser2 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class MyUser(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name: "$field" -> "$value"
            """.trimIndent())
            field = value // field is essentially for address
            // field you can modify it in setter but you cannot do it
            // in getter
        }
}

val user2 = MyUser("Alice")




