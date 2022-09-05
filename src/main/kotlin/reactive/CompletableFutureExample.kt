package reactive

import java.util.concurrent.CompletableFuture

fun main() {
    val compeletableFuture = CompletableFuture.supplyAsync{
        Thread.sleep(2000)
        sum(100, 200)
    }

    println("계산 시작")
    compeletableFuture.thenApplyAsync(::println) // 논 블로킹으로 동작


//    val result = compeletableFuture.get() // 는 블로킹으로 동작
//    println(result)

    while(!compeletableFuture.isDone) {
        Thread.sleep(500)
        println("계산 결과를 집계 중입니다.")
    }

    println("계산 종료")
}