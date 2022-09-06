package advanced


// 컴파일러가 equals, hashCode, toString, componentN, copy 를 자동으로 만들어 준다.
// 자바는 롬복을 사용해서 만들었음.
// jdk 15부터는 data class와 비슷한 record를 제공?
// 데이터를 저장하는 목적으로 하는 클래스임
// equals는 객체에 대한 동등성 비교를 한다.
data class Person(val name: String, val age: Int) {

//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Person
//        if(name != other.name) return false
//        if(age != other.age) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + age
//        return result
//    }

}



fun main() {

    val person1 = Person(name ="tony", age = 12)
    println("이름= ${person1.component1()}")
    println("나이= ${person1.component2()}")

    //구조분해할당
    val (name, age) = person1

    println("이름= ${name}, 나이 = ${age}")

    val person2 = Person(name ="tony", age = 12)



    println(person1.toString())
    // 객체 동등성 비교
    println(person1 == person2)
    // equals각 true 인데 hashCode가 다르게 나온다면? ...
    val set = hashSetOf(person1)
    println(set.contains(person2));
    // var 로 선하여, 값 재설정, 불변성이 깨졌을 때
    //person1.name = "strange"
    //println(set.contains(person2));
    // 멀티쓰레드 환경에서 문제가 될 수 있음.

    // copy를 사용하면 새로운 객체
    //val person3 = person1.copy() // 그대로 복사


    val person4 = person1.copy(name = "strange") // 그대로 복사
    val set4 = hashSetOf(person4)
    println(set4.contains(person1));







}