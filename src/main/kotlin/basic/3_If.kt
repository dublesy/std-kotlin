fun main() {
    // if..else 사용
    val job = "Software Developer"

    if(job == "Software Developer") {
        println("개발자")
    } else {
        println("개발자 아님")
    }
    // 코틀린의 if..else는 표현식이다. 자바는 구문이다. 값을 할당할 수 없다.
    val age : Int = 10

    val str = if (age > 10) {
        "어른"
    } else {
        "아이"
    }

    // 코틀린은 삼항 연산자가 없다. if..else가 표현식이므로 불필요 하다.
    val a = 1
    val b = 2
    val c = if(b > a) b else a
}