package reactive

import java.util.Observable
import java.util.Observer


class Coffee(val name: String)

// Subject
class Barista : Observable() {
    fun orderCoffee(name: String) {
        this.coffeeName = name
    }

    private lateinit var coffeeName: String

    fun makeCoffee() {
        setChanged()
        notifyObservers(Coffee(this.coffeeName))
    }
}

// Observer
class Customer(val name: String) : Observer {
    override fun update(o: Observable?, arg: Any?) {
        val coffee = arg as Coffee
        println("${name}이 ${coffee.name}을 받았습니다")
    }
}
fun main() {
    val barista = Barista()
    barista.orderCoffee("아이스 아메리카노")
    val customer = Customer("고객1")
    val customer2 = Customer("고객2")
    val customer3 = Customer("고객3")
    barista.addObserver(customer)
    barista.addObserver(customer2)
    barista.addObserver(customer3)
    barista.makeCoffee()
}
// 고객1이 아이스 아메리카노을 받았습니다