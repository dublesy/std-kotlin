package basic

//컨스트럭터, 후행쉼표
class Coffee (
    val name: String,
    val price: Int,
    val brand: String,
    ) {

}
class Coffee1 (
    var name: String = "",
    var price: Int = 0,
    var iced: Boolean = false,
) {
    //커스텀 getter
    val brand: String
        get() = "스타벅스"

    val logic: String
        get() {
            //로직이 필요한경우 함수처럼 작성
            return "스타벅스"
        }
    //field 는 식별자임
    var quantity : Int = 0
        set(value) {
            if(value > 0) { // 수량이 0 이상인 경우에만 할당
                field = value
            }
        }
}


    // emptyClass
class EmptyClass;

fun main() {
    //코틀린의 컴파일러가 getter, setter 메소드를 자동으로 생성해줘서 setter를 사용해서
    // 값을 할당하는 것을 볼 수 있다.

    // val만 있으면 getter만 자동으로 생성해준다.
    val coffee = Coffee("아이스 아메리카노", 2000, "maxim")
    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price}")

    val coffee1 = Coffee1()
    coffee1.name = "아이스 아메리카노"
    coffee1.price = 2000
    coffee1.quantity = 1
    coffee1.iced = true
    if(coffee1.iced) {
        println("아이스 커피")
    }
    println("${coffee1.brand} ${coffee1.name} 가격은 ${coffee1.price} 수량은 ${coffee1.quantity}")
    //자바는 함수로 상태를 표현, 코틀린은 프로퍼티로 상태를 표현

}

