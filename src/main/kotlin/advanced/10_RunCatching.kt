package advanced

import java.lang.Exception

fun getStr(): Nothing = throw Exception("예외 발생 기본 값으로 초기화")

fun main() {
//    val result = try {
//        getStr()
//    } catch (e: Exception) {
//        println(e.message)
//        "기본값"
//    }
//
//    val result = runCatching {
//        getStr()
//    }.getOrElse {
//        println(it.message)
//        "기본값"
//    }

//    val result = runCatching {
//        "성공"
//    }.getOrNull()

//    val result = runCatching {
//        getStr()
//    }.exceptionOrNull()
//
//    result?.let {
//        println(it.message)
//        throw it
//    }

//    val result = runCatching {
//        getStr()
//    }.getOrDefault("기본 값")

//    val result = runCatching {
//        getStr()
//    }.getOrElse {
//        println(it.message)
//        "기본 값"
//    }

//    val result = runCatching {
//        //getStr()
//        "성공"
//    }.getOrThrow()

//    val result = runCatching {
//        "안녕"
//    }.map {
//        "${it}하세요"
//    }.getOrThrow()

//    val result = runCatching {
//        "안녕"
//    }.map {
//        throw Exception("예외")  //runCatching에서는 정상이였다가 map에서 throw가 발생하면 getOrDefault 의 디폹트가 실행되지 않음.
//    }.getOrDefault("기본 값")

//    val result = runCatching {
//        "안녕"
//    }.mapCatching {
//        throw Exception("예외")  //runCatching에서는 정상이였다가 map에서 throw가 발생하면 getOrDefault 의 디폹트가 실행되지 않음.
//    }.getOrDefault("기본 값")

//    val result = runCatching {
//        //'정상" //성공시에는 recover 동작하지 않음.
//        getStr()
//    }.recover { "복구" }
//        .getOrNull()

    val result = runCatching {
        //'정상" //성공시에는 recover 동작하지 않음.
        getStr()
    }.recoverCatching {
        throw Exception("예외")
    }.getOrDefault("복구")

    println(result)
}

// 예외 발생 기본 값으로 초기화
// 기본값