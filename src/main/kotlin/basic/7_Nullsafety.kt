package basic
fun main() {
    // null 로 초기화시 컴파일 오류 ㅂ라생
    //var a : String = null
    //nul 값 재할당시 컴파일 오류 발생
    //var b : String = "aabbcc"
    //b = null
    //코틀린은 nullable 한 타입을 따로 제공함
    //var a : String? = null
    //nullable한 타입에 대한 접근은 안전연산자를 사용하여 해결한다.
    //println(a?.length)
    //val b: Int = if(a != null) a.length else 0
    //println(0)
    //엘비스 연산자 : 좌변이 null인 경우 우변으로 처리한다.
    //val c = a?.length ?:0
    //println(c)

    val nullableStr = getNullStr()
    val nullableStrLength = nullableStr?.length ?:"null인 경우 반환".length
    println(nullableStrLength)

    val length = getLengthIfNotNull(null)
    println(length)

    //throw NullPointerException()

    val c: String? = null
    //val d = c?.length
    // 단언연산자, NPE가 발생할 수 있음.
    val d = c!!.length

    //코틀린에서 자바코드를 호출할 때 항상 nullable을 염두해야 한다.
    //println(Java_NullSafety.getNullStr()?.length ?:0)

}

fun getNullStr() : String? = null

fun getLengthIfNotNull(str: String?) = str?.length ?:0