package basic

import java.lang.Exception
import java.lang.IllegalArgumentException

fun main() {

    //자바에서는 체크드 익셉션은 컴파일 에러가 발생하기 때문에 무조건 try-catch로 감싸거나 throws로 예외를 전파해야 한다.
    //코틀린에서는 체크드 익셉션을 강제하지 않는다.
    //원하는 경우에는 try-catch를 쓸 수 있다.
//    try {
//        Thread.sleep(1)
//    } catch (e: Exception){
//        //예외 처리
//        println("예외처리")
//    }

    // java와 동일하게 finally를 사용할 수 있다.
    try {
        throw Exception()
    } catch (e: Exception){
        //예외 처리
        println("예외처리")
    } finally {
        println("finally 실행!")
    }

    // 코틀린의 try-catch문은 표현식이다. 값전달 가능
    val a = try {
        "1234".toInt()

    } catch (e: Exception) {
        println("예외발생")
    }

    println(a)

    // 직접 익센셥 발생시키기
    // throw Exception("예외 발생!!!")

    //익셉션도 표현식이다.


    val b: String? = null
    val c: String = b ?: failFast("b is null")

    println(c.length)
    println("이메시지는 출력될까?")

}

// 기본적으로 익셉션은 Nothing을 암묵적으로 반환한다.
fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}