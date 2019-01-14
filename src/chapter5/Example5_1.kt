package chapter5

data class House(val address: String, val price: Int)

fun findTheMostExpensive(houses: Collection<House>) {
    var mostExpensive = 0
    var theMoseExpensiveHosue: House? = null
    for (house in houses) {
        if (house.price > mostExpensive) {
            mostExpensive = house.price
            theMoseExpensiveHosue = house
        }
    }
    println(theMoseExpensiveHosue)
}

object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val houses = arrayListOf(House("Changzhou", 90), House("Suzhou", 89))
        findTheMostExpensive(houses)

        println(houses.maxBy { it.price })
        println(houses.maxBy{ it.price })

        println(houses.maxBy(House::price))

        val sum = { x: Int, y: Int -> x + y }
        print(sum(1, 2))

    }

}

data class Milk(val brand: String, val id: Int)

object Demo1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val milks = arrayListOf(Milk("a", 1), Milk("b", 2), Milk("c", 3), Milk("d", 4))
        println(milks.asSequence().map { it.id * it.id }.filter { it > 3 }.toList())
    }
}