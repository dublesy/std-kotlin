package advanced

import java.util.LinkedList
import java.util.stream.Collectors

fun main() {

    // immutable
    val currencyList = listOf("달러", "유로", "원")
    // add가 없다. 새로운 값을 쓰거나 삭제할 수가 없다.
    //currencyList.add("엔")


    // mutable
    val mutableCurrencyList = mutableListOf<String>()
    mutableCurrencyList.add("달러")
    mutableCurrencyList.add("유로")
    mutableCurrencyList.add("원")

    val mutableCurrencyList1 = mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("원")
    }

    //immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // immutable map
    val numberMap = mapOf(
        "one" to 1,
        "two" to 2,
    )

    // mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1
    //mutableNumberMap.put("two", 2)
    mutableNumberMap["two"] = 2
    mutableNumberMap["three"] = 3

    // Collection builder 사용하기
    // buildList 내부에서는 mutableList 를 사용하고 반환할 때는 immutable 한 리스트로 반환한다.
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }
    // 추가 불가
    //numberList.add(4)


    // LinkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(1)
        add(2)
        addLast(4)
    }

    // ArrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    val iterator = currencyList.iterator();
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("==============")

    for (currency in currencyList) {
        println(currency)
    }

    println("==============")

    currencyList.forEach {
        println(it)
    }

    // for loop -> map
    var lowerList = listOf("a", "b", "c")
    val upperList = mutableListOf<String>()

//    for ( lowerCase in lowerList) {
//        upperList.add(lowerCase.uppercase())
//    }
//    println(upperList)

    val upperList1 = lowerList.map {
        it.uppercase()
    }
    println(upperList1)

    val filteredList = mutableListOf<String>()

//    for (upperCase in upperList1) {
//        if (upperCase == "A" || upperCase == "C") {
//            filteredList.add(upperCase)
//        }
//    }
//
//    println(filteredList)

    // 코틀린은 종결연산자가 필요 없다.
    val filteredList1 = upperList1.filter { it == "A" || it == "C" }

    //java stream은 중간연산자를 사용했으면 반드시 종결연산자를 사용해야 리턴해줄 수 있다.
    val filteredList2 = upperList.stream().filter{ it == "A" || it == "C" }.collect(Collectors.toList())

    // 코틀린도 시퀀스를 사용하면 자바 스트림과 동일하게 종결연산자를 사용해야 리턴해줄 수 있다.
    val filteredList3 = upperList1
        .asSequence()
        .filter { it == "A" || it == "B" }
        .toList()

    // 인라인 함수를 사용할것인지 선택적으로 사용해야함.
    // 인라인 함수를 filter 함수가 5개라면 5개의 컬렉션이 만들어 진다.
    // 데이터가 많으면 OOM 익셉션이 발생할 수 있다.
    // 시퀀스를 사용하면 터미널오퍼레이터 에서 컬렉션을 만들기 때문에 메모리가 적게 사용한다.
    // 10만건 이하인 경우 chain 이 많아진다고 해도 인라인 함수를 사용하는 것도 퍼포먼스상 좋다고 한다.

    println(filteredList1)
    println(filteredList2)
    println(filteredList3)

}