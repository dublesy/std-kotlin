// enum 또한 class 이기 때문에 생성자와 프러퍼티를 사용할 수 있다.
enum class PaymentStatus(val label: String) : Payable {
    UNPAID("미지급") {
        override fun isPayable(): Boolean = true
                  },
    PAID("지급완료") {
        override fun isPayable() = false
                 },
    FAILED("지급실패") {
        override fun isPayable() = false
                   },
    REFUNDED("환급") {
        override fun isPayable() = false
    };


}

interface Payable {
    fun isPayable() : Boolean
}

fun main() {
    //print(PaymentStatus.UNPAID.label)

//    if(PaymentStatus.UNPAID.isPayable()) {
//        print(PaymentStatus.UNPAID.label)
//    }

    //valueOf 함수로 enum class를 만들 수 있다.
    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    //동등성 비교
    if(paymentStatus == PaymentStatus.PAID) {
        println("결제 완료 상태")
    }

    //values 함수는 enum class 상수들의 리스트를 가져올 수 있다.
    for(status in PaymentStatus.values()) {
        println("[${status.name}][$status](${status.label}) : [${status.ordinal}]")

    }


}