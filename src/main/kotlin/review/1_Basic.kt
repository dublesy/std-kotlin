package review

import java.lang.IllegalArgumentException


// 코틀린 기초
// 코틀린은 루프를 제외하고 대부분 식(expression)으로 구성됨
// expression은 값을 만들지만 statement는 블럭의 최상위 요소로 존재할 뿐 값을 만들지 않는다.


// 함수는 fun으로 정의하며 블럭문이 아닌 식으로도 정의 가능
fun hello() = println("Hello")

// val은 java final과 동일하게 재할당이 불가능
val name1: String = "Dexter"

// var는 재할당 가능
var name2: String = "Dexter"

// if문도 expresstion으로 사용 가능
fun max(a: Int, b: Int) = if (a > b) a else b

// 변수를 뒤에 선언하는 이유?
// 변수를 뒤에 지정하게 되면 타입 지정을 생략할 수 있게 해준다.

// 문자열 템플릿
fun main_1() {
    val name = "Dexter"
    println("Hello $name")
    println("Hello ${name}")

    val person = Person("Dexter", 26)
    println(person.name)
    println(person.age)

    val rectangle = Rectangle(200, 300)
    println(rectangle.isSquare)




}

// class

class Person(
    // val은 읽기 전용으로 비공개 필드와 getter를 제공
    val name: String,
    // var는 변경 가능하므로 비공개 필드와 getter, setter 제공
    var age: Int,
)

// 커스텀 접근자
class Rectangle(val height: Int, val width: Int) {
    //커스텀 접근자를 지정할 수 있다.
    val isSquare : Boolean
        get() = height == width
}

enum class Color {
    RED,
    ORANGE,
    YELLOW
    ;
}

fun getStringColor(color: Color) =
    when (color) {
        Color.RED -> "RED"
        Color.ORANGE -> "ORANGE"
        Color.YELLOW -> "YELLOW"
    }

fun getStringColor2(color: Color) =
    when (color) {
        Color.RED, Color.YELLOW, Color.ORANGE -> "COLOR"
    }

fun getStringColor3(color1: Color, color2: Color) =
    when {
        (color1 == Color.RED || color2 == Color.ORANGE) -> "RED ORANGE"
        else -> throw RuntimeException()
    }

// 스마트 캐스팅

interface Expr
class Num(val value:Int) : Expr
class Sum(var left:Expr, val right: Expr) : Expr

fun eval(e: Expr) : Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException()
    }

/**
 * 클래스의 프로퍼티를 스마트 캐스팅하고 싶다면 val이면서 커스텀 접근자가 정의되어 있지 않아야 한다.
 *  - var거나 커스텀 접근자가 있으면 언제나 같은 타입을 반환해준다는 것을 확신할 수 없기 때문에...
 */
fun main1(){
    val sum = Sum(Num(1), Num(2))
    if (sum.left is Num) {
        //println(sum.left.value) 컴파일 에러 (left는 var 이다.)
    }
    // 스마트 캐스팅 가능(right는 val 이기 때문)
    if (sum.right is Num) {
        println(sum.right.value)
    }
}
// 타입 검사와 동시에 형변환을 하도록 스마트 캐스팅 지원

//expression when, if
fun main12() {
    expressionIf(Num(1))
    expressionIf(Num(2))
    val sum = expressionIf( Sum(Num(1), Num(2)))
    println(sum)
    iterationEx()
}

fun expressionWhen(e: Expr) : Int =
    when(e) {
        is Num -> {
            println(e.value)
            e.value // 표현식의 블럭문은 마지막 값이 리턴 값이 된다.
        }
        is Sum -> {
            println("${e.left} + ${e.right}")
            expressionWhen(e.left) + expressionWhen(e.right)
        }
        else -> throw IllegalArgumentException()
    }

// if 절도 가능하지만 when이 더 깔끔해 보인다.
fun expressionIf(e: Expr) : Int =
    if (e is Num) {
        println(e.value)
        e.value
    } else if( e is Sum) {
        println("${e.left} + ${e.right}")
        expressionIf(e.left) + expressionIf(e.right)
    } else {
        throw IllegalArgumentException()
    }

// iteration

fun iterationEx() {
    // 1 ~ 10
    //for (i in 1 .. 10) println(i)

    //for (i in 1..10 step 2) println(i)

    //for ( i in 10 downTo 1 step 2) println(i)

    for(i in 10 downTo 1 step 2) {
        print("$i, ")
    }


    //map의 key, value를 for 문으로 풀어낼 수 있다.
    for((key, value) in  mutableMapOf(Pair("A",1))) {
        println(key + value)
    }

    //withIndex를 활용하면 리스트의 index도 간편히 가져올 수 있다.
    for ((index, value) in mutableListOf(1,2,3).withIndex()) {
        println("$index row $value ")
    }


//    for ( i in 0 .. 9) {
//        for ( b in 0 .. i) {
//            print("*")
//        }
//        println("")
//    }
//
//    for ( i in 0 .. 9) {
//        for ( b in i .. 9-1) {
//            print(" ")
//        }
//        for ( c in 0 .. i*2) {
//            print("*")
//        }
//
//        println("")
//    }
//    println("")
//    for ( i in 10 downTo 0) {
//        for ( b in i .. 9) {
//            print(" ")
//        }
//        for ( c in 0 .. (i-1) * 2) {
//            print("*")
//        }
//
//
//        println("")
//    }
}

fun main123() {
    //iterationEx()
    val joinToString = joinToString(separator = "|", collection = listOf(1, 2, 3))
    println(joinToString)
}

// in 으로 범위 검사
fun isSmallLetter(c: Char) = c in 'a' .. 'z' // 컴파일 -> 'a'<= c && c <= 'z'
fun isNotSmallLetter(c: Char) = c !in 'a' .. 'z'
fun recognize(c: Char) : String =
    when (c) {
        in 'a'..'z' -> "is small letter"
        else -> "is not small letter"
    }

// 예외
// 코틀린은 모두 언체크 예외로 이루어져 있다.

// 3장 함수 정의와 호출
// Default and Named Argument
fun <T> joinToString(collection: Collection<T>, separator: String = ","): String {
    val builder = StringBuilder()
    for ((index, element) in collection.withIndex()) {
        if (index > 0 ) builder.append(separator)
        builder.append(element)
    }
    return builder.toString()
}
// 아규먼트에 디폴트 값을 지정할 수 있고 호출 시 네이밍이 가능ㅎ안다.
// named argument로 자바의 빌더를 대체할 수 있다.
// Default Argument를 자바에도 지원하려면
//  @JvmOverloads를 붙이면 각각의 아규먼트에 맞는 오버로딩 메서드를 만들어 준다.


// 최상위 함수와 최상위 프로퍼티
// 최상위 함수를 바이트 코드로 변환 후 자바로 디컴파일 해보면 해당 코드가
// 작성된 파일명 kt라는 클래스의 static 메서드로 정의된다.
// 최상위 프로퍼티 val? const?
// * 외상위 프로퍼티에 val, var 모두 사용 가능하다.
// * val은 재할당이 불가능한건 맞지만 실제 호출 시 내부의 getter를 호출한다.
// * 상수를 선언할 때 getter를 호출하는건 자연스럽지 못하므로 const val NAME = "Dexter"와 같이 const를 붙여준다.

// 확장함수
// 기존에 만들어져 있던 클래스의 함수를 외부에서 추가하여 확장시키는 방법
// String의 확장 함수 정의. 확장이 될 대상을 **수신 객체 타입** 이라고 칭하며, 호출된 수신 객체는 해당 함수에서 this로 참조 가능

fun String.lastChar(): Char = this[this.length - 1]
// 확장함수는 캡슐화를 지키므로 수신 객체를 this로 참조하더라도 확장 함수에서는 확장할 클래스 내부로 접근이 제한된
// 대상은 접근이 불가능

// 자바에서 확장 함수 호출하기
// * 확장함수는 내부적으로 수신 객체를 첫번째 인자로 갖는 static method로 정의된다.
// * 그러므로 자바에서도 정적 메서드 호출로 호출할 수 있으며, static method이므로 런타임 부가 비용이 없다.
// 확장함수는 정적 메서드 호출에 대한 syntatic sugar일 뿐 대단한 건아니다.

// 확장함수는 오버라이딩 불가

open class Parent
class Child : Parent()

fun Parent.hi() = println("Parent.hi")
fun Child.hi() = println("Child.hi")

fun main13() {
    Child().hi()
    val parent : Parent = Child()

    parent.hi()
}

// 내부적으로 정적 메서드(static method)로 구현되므로 오버라이딩은 불가능하기 때문에 실제 인스턴스는
// Child나 Parent의 hi가 호출된다.

// 확장 프로퍼티
val String.lastChar: Char
    get() = get(length -1)

var StringBuilder.lastChar : Char
    get() = get(this.length -1)
    set(value: Char) {
        this.setCharAt(this.length - 1, value)
    }

fun main14() {
    val sb = StringBuilder("Hello World")
    println(sb.lastChar)
    sb.lastChar = 'k' // lastChar의  set 프로퍼티 호출
    println(sb.lastChar)

}

// 가변 인자 함수
fun print(vararg args: String) {
    for (arg in args) {
        println(arg)
    }
}

fun printArray(args: Array<String>) {
    // Array 객체를 넘길때도 * 를 반드시 붙여줘야 한다.
    print(*args)
}

fun main() {
    //printArray(arrayOf("1","2"))

    print("1", "2")

    // 구조분해
    for ((key, value) in mutableMapOf(Pair("A", 1))) {

    }

    // withIndex를 활용하면 리스트의 index도 간편히 가져올 수 있다.
    for ((index, value) in mutableListOf(1, 2, 3).withIndex()) {

    }
}


// 중위함수
val map = hashMapOf(1 to "one", 2 to "two")
// 인자가 하나뿐인 일반 메서드나 확장함수는 중위 호출이 가능하다.

// 문자열 및 정규식 다루기

fun regex() {
    // 명시적 정규 표현식을 표현
    val regex = "\\d\\d".toRegex()

    // 삼중따옴표는 역슬래쉬를 한번만 사용할 수 있다.
    val regex2 = """\d\d""".toRegex()
}