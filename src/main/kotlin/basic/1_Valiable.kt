package basic

var x = 5 // 클래스를 만들지 않고도 변수를 선언할 수 있다. 이러한 위치를 탑레벨에 위치한다고 함. 클래스나 함수에 속하지 않는다.

fun main() {
    x += 1
    println(x)
    /**
     * val 은 valiable
     */
    val a : Int = 1

    /**
     * 타입의 추론
     */
    val b = 1

    /**
     * 지연할당
     *
     */
    val c : Int
    c = 3

    /**
     * 지연할당시 타입을 선언해주지 않으면 컴파일 오류가 발생한다.
     */
    //val d
    //d = 123
    /**
     * val(value) : 값 재할당 불가
     * var(variable) : 값 재할당 가능
     * 값 재할당 시 컴파일 오류 발생
     */
    //val e: String = "Hello"
    //e = "World"
    /**
     * var 로 변경하여 갑 재할당을 하더라도
     * 타입이 선언되어 있지 않으면 컴파일 오류가 발생한다.
     */
    //var f = 123
    //f = "hi"



}