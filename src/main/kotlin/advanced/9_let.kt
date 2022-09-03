package advanced

fun main() {
    //val str: String? = null
    val str: String? = "안녕"

    val result: Int? = str?.let {
        println(it)

        val abc: String? = "abc"
        val def: String? = "def"
        if(!abc.isNullOrEmpty() && !def.isNullOrEmpty()) {
            println("abcdef가 null이 아님")
        }
//        abc?.let {
//
//            def?.let {
//                println("abcdef가 null이 아님")
//            }
//        }
        1234
    }

    println(result)

}