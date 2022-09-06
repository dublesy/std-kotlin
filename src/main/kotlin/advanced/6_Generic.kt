package advanced

class MyGenerics<out T>(val t: T){
}

class Bag<T> {

    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>,
    ) {
        to.addAll(from)
    }
}

fun main() {
    var bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1","2"), mutableListOf<String>("3","4"))


    //제네릭을 사용한 클래스의 인스턴스를 만드려면 타입아규먼트를 제공
    val generics = MyGenerics<String>("테스트")
    val charGenerics : MyGenerics<CharSequence> = generics
    // 타입 생략가능
    //val generics = MyGenerics("테스트")
    //변수의 타입에 제네릭을 사용한 경우
    //val list1: MutableList<String> = mutableListOf()
    // 타입악휴먼트를 생성자에서 추가
    //var list2 = mutableListOf<String>()

    //val list3 : List<*> = listOf<String>("테스트")
    //val list4 : List<*> = listOf<Int>(1,2,3,4)

    // 변성
    // PECS(Producer-Extends, Consumer-Super
    // 공변성은 자바 제네릭의 extends 코틀린에선 out
    // 반공변성은 자바 제네릭에서 super 코틀린에서 in
    // 무공변성

}