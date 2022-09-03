package advanced

//fun plus(a: Int, b: Int) = a + b

// tuple
// f((1, 3)) = 1 + 3 = 4
// f(1,3) = 1 + 3 = 4

//data class Tuple(val a : Int, val b: Int)
//fun plus(tuple : Tuple) = tuple.a + tuple.b

// Pair 라는 클래스를 제공함
fun plus(pair: Pair<Int, Int>) = pair.first + pair.second

fun main() {
    //println(plus(1,3))
    //val plus = plus(Tuple(1,4))
    val plus = plus(Pair(1,4))
    println(plus)

    val pair = Pair("A",1)
    //pair.first = "asdf" //불변이라 수정할 수 없음
    val newPair = pair.copy(first="B")
    println(newPair)

    val second = newPair.component2()
    println(second)

    val list = newPair.toList()
    println(list) //불변 리스트

    val triple = Triple("A","B","C")
    println(triple)
    triple.first
    triple.second
    triple.third

    val newTriple = triple.copy(third = "D")
    println(newTriple)

    println(newTriple.component3())

    val (a: String, b: String, c: String) = newTriple
    println("$a, $b, $c")


    var list3: List<String> = newTriple.toList()
    val (a1, a2, a3) = list3
    println("$a1, $a2, $a3")
    //배열이나 리스트는 componentN은 5까지만 제공한다.

    //val map = mutableMapOf("이상훈"  to "개발자")
    val map = mutableMapOf(Pair("이상훈", "개발자"))
    for ( (key, value) in map) {
        println("${key}의 직업은 $value")
    }

}