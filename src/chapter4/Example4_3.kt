package chapter4

class Client(val name: String, val age: Int) {
    override fun equals(other: Any?): Boolean {
        return if (other == null || other !is Client) false else {
            name == other.name && age == other.age
        }
    }
}

// Any is essentially Object in Java, and in Java == compares reference except for primitive type, but in Kotlin == use equals to compare. you should use == as much as possible. To compare reference, use ===