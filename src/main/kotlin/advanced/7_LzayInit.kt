package advanced

class HelloBot {
    // by lazy를 통해 사용시점에 1회만 로직수행 한다.
    //val greeting: String by lazy {
    val greeting: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        println("초기화 로직 수행")
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
    val helloBot = HelloBot()

    //로직 수행
    //helloBot.greeting = getHello()
    //불변, 멀티 쓰레드 환경에서 안전하게 동작하게 하기 위해서
    for(i in 1 .. 5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }

}