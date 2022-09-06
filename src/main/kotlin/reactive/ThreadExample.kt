package reactive


fun main() {
    for (i in 0..5) {
        val thread = Thread {
            println("current-thread-name : ${Thread.currentThread().name}")
        }
        thread.start()
    }
    println("current-thread-name : ${Thread.currentThread().name}")
}

//호출할때마다 결과가 달라진다.