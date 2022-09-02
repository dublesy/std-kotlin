open class Dog {
    open var age: Int = 0
    open fun bark() {
        println("멍멍")
    }
}
// final 키워드로 상속을 막을 수 있다.
open class Bulldog(final override var age: Int = 0) : Dog() {
    final override fun bark() {
        //println("야용")
        //상위클래스의 함수나 프러퍼티 재사용
        super.bark()
    }
}

//class ChildBulldog : Bulldog() {
//    override  var age: Int = 0
//
//    override fun bark() {
//        println("야용")
//    }
//}

abstract class Developer {
    abstract var age: Int
    abstract fun code(lanuage: String)
}

class BackendDeveloper(override var age: Int) : Developer() {

    //override var age: Int = 0

    override fun code(lanuage: String) {
        println("I code with $lanuage")
    }


}

fun main() {
    val dog = Bulldog(age = 2)
    println(dog.age)

    val backendDeveloper = BackendDeveloper(age = 20)
    println(backendDeveloper.age)
    backendDeveloper.code("kotlin")

}


