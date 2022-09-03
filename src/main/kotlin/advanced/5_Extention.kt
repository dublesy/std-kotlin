package advanced

//확장함수
//리시버, 수신자객체, this
fun String.first() : Char {
    return this[0]
}

fun String.addFirst(char: Char) : String {
    return char + this.substring(0)
}


class MyExample {
    fun printMessage() = println("클래스 출력")

}

// 동일한 시그니처의 함수나 변수가 있으면 항상 클래스가 직접 보유하고 있는 멤버가 우선된다.
//fun MyExample.printMessage() = println("확장 출력")
// 인자가 다르면 동일한 시그니처가 아님
// 코틀린이 버전업되서 동일한 시그니처가 확장되었다면 기존 확장함수와 충돌이 날 수도 있어 클래스의 함수가 적용되어
// 예기치 못한 오류가 발생할 수 있다.
fun MyExample.printMessage(message: String) = println(message)

fun MyExample?.printNulOrNotNull() {
    if (this == null) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main() {
    MyExample().printMessage()
    MyExample().printMessage("확장 츄")
    var myExample: MyExample? = null
    myExample.printNulOrNotNull() // null 안정성을 보장하고 있기 때문에 널 안정성 ? 를 선언하지 않아도 된다.
    println("ABCD".first())
    println("ABCD".addFirst('Z'))

}