class Product(val name: String, val price: Int)


interface Wheel {
    fun roll()
}

interface Order {
    //디폴트함수
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다.")
    }

    //디폴트함수
    fun printId() = println("5678")
}


// 상위 인터페이를 가질 수 있다.
interface Cart : Wheel {

    var coin: Int
    fun add(product: Product)


    // 인터페이스에서는 프로퍼티에 백킹 필드를 사용할 수 없다.
    val weight : String
        get() = "20KG"

    //디폴트 함수
    fun rent () {
        if( coin > 0) {
            println("카트를 대여합니다.")
        }
    }

    override fun roll() {
        println("카트가 굴러갑니다.")
    }

    fun printId() = println("1234")
}

// 인터페이스의 경우에는 생성자 호출이 아닌 인터페이스명만 추가
// 인터페이스 프러퍼티는 override를 해줘야 함.
// 복수개의 인터페이스를 구현할 때 문제점은 각기 다른 클래스에 동일한 시그니처를 가진 함수가 존재할 경우...
class MyCart(override var coin: Int) : Cart, Order {

    // 복수개의 인터페이스 동일 시그니처 함수
    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가됐습니다.")

        //주문하기
        super<Order>.add(product)
    }

    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }

}



fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "장난감", price = 1000))
    cart.printId()
}