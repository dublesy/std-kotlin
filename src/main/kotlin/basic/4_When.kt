package basic

fun main() {
    // 자바 switch 코드를 코틀린의 when 식으로 변환한 코드
    val day = 2

    val result = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        5 -> "금요일"
        6 -> "토요일"
        7 -> "일요일"
        else -> "기타"
    }
    println(result)

    // else 를 생략할 수 있다.
    when(getColor()) {
        Color.RED -> print("red")
        Color.GREEN -> print("green")
    }

    // 여러개의 조건을 콤마로 구분해 한줄에서 정의할 수 있다.
    when(getNumber()) {
        0, 1 -> println("0 or 1")
        else -> println("not 0 or 1")
    }

}

enum class Color {
    RED, GREEN
}

fun getColor() = Color.RED

fun getNumber() = 2