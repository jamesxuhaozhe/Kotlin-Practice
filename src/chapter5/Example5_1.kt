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