package advanced


class `7_LateInit` {
    lateinit var text: String
    val textInitialized: Boolean
        get() = this::text.isInitialized

    fun printText() {
        //text = "안녕하세요"
        //if(this::text.isInitialized) { //isInitialized는 class 내부에서 사용 할 수 있음
        //    println("초기화됨")
        //} else {
        //}
        println(text)

    }
}


fun main() {

    val test = `7_LateInit`()
    //test.text = "하이요"
    if(!test.textInitialized) {
        test.text = "하이요"
    }
    test.printText()
}