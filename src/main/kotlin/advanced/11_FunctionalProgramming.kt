package advanced

fun main() {
    // 함수형 프로그래밍
    // 일급객체
    // 함수는 값이 될 수 있고 값은 함수가 될 수 있다.
    //val list = mutableListOf(printHello)
    //함수실행 표기법으로 실행
    //list[0]()
//    val func = list[0]
//    func()
//    call(printHello)
//    fun 으로 작성한 함수는 값으로 받을 수 없는듯...
//    val list = mutableListOf(printNo)
//    call(printNo)
//    val result: Int = plus(1,3,5)
//    println(result)
//    val list = listOf("a","b","c")
//    val printStr : (String) -> Unit = { println(it) }
//    //고차 함수 실행
//    //forEachStr(list, printStr)
//    forEachStr(list) {
//        println(it)
//    }
//    val upperCase : (String) -> String = {it.uppercase()}
//    println(list.map(upperCase))
    //내부의 익명함수 호출
    //outerFunc()()

//    val func = outerFunc()
//    func()

//    arg1 {
//        it.length
//        it.first()
//    }
//
//    arg2 { a, b ->
//        a.length
//        b.first()
//    }

    //val callReference : () -> Unit = { printHello() }
//    val callReference = ::printHello
//    callReference()()

    val numberList = listOf("1","2","3")
    numberList.map { it.toInt() }.forEach { println(it)}
    numberList.map(String::toInt).forEach(::println)

    //arrow lib


}

val printHello : () -> Unit = { println("Hello")}

fun arg1(block: (String) -> Unit) {}

fun arg2(block: (String, String) -> Unit) {}

// 함수를 받아서 처리하는 함수를 고차 함수라고 한다.
fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for( item in collection) {
        action(item)
    }
}

//val printMessage: (String) -> Unit = { message: String -> println(message) }
// 줄이기
//val printMessage2: (String) -> Unit = { message -> println(message) }
// 줄이기
//val printMessage3: (String) -> Unit = { println(it) }

//val plus : (Int, Int, Int) -> Int = {a, b, c -> a + b + c}

//val func: () -> String = {""}

// 함수를 인자로 받아 실행하는 함수
//fun call(block: () -> Unit) {
//    block()
//}
//fun printNo() = println("No!")

//fun outerFunc() : () -> Unit {
    //익명 함수
//    return fun() {
//        println("이것은 익명함수!")
//    }
//    return {
//        println("이것은 익명함수!")
//    }
//}

//람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y}

//최대한 생략한 람다식
//내부 람다변수에 대해서 타입은 생략할 수 없다.
val sum2 = {x: Int, y: Int -> x + y}

fun outerFunc() : () -> Unit = { println("이것은 익명함수!") }


