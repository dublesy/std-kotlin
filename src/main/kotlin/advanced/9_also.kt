package advanced

class User(val name: String, val password: String) {

    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("검증 성공!")
        } else {
            println("검증 실패!")
        }
    }

    fun printName() = println(name)

}

fun main() {
//    val user: User = User(name = "tony", password = "1234")
   //user.validate()

    User(name = "tony", password = "1234").also {
        it.validate()
        it.printName()
    }

    // 스코프 함수를 사용할 때 유의할 점
    // 기능들이 유사하고 목적들이 비슷하기 때문에
    // 팀내 컨벤션에 따라서 작성할 수 있도록 한다.
    // 수신자 객체의 차이점
    // this는 키워드
    // val this: String? = null // 예약어 이므로 사용할 수 없음
    // it은 소프트 키워드 다른 용도로 사용 가능
    // val it : String? = null
    // let 의 중첨 , it이 어디의 it인지 가독성이 떨어짐
    // it이 아니라 a: String -> ... b:String -> ... 요런식으로 변경해서 사용하면 가독성 및 외부 접근이 가능함

}