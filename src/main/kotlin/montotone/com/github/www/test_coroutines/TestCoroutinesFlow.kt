package montotone.com.github.www.test_coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.Exception
import kotlin.system.measureTimeMillis

//2020年10月12日17:44:12
//https://kotlinlang.org/docs/reference/coroutines/flow.html
fun main() {
//    testSequences()
//    testSuspendFlow()
    testFlow()
//    testFlowCatch()
}

fun testFlowCatch() {
    runBlocking {
        fun simple(): Flow<Int> = flow {
            for (i in 1..3) {
                delay(100)
                emit(i)
            }
        }.map {
            check(it <= 1) { "Crashed on $it" }
            it
        }

        //first
//        try {
//            simple().collect {
//                println(it);
//            }
//        } catch (e: Throwable) {
//            println("Caught $e")
//        }
        //second
//        simple().catch { e -> emit(value = 1) }
//                .collect {
//                    println(it)
//                }
        //third
        //Catching declaratively
//        simple()
//                .onEach { value ->
//                    check(value <= 1) { "Collected $value" }
//                    println(value)
//                }
//                .catch { e -> println("Caught $e") }
//                .collect()

        //最后结束调用
//        simple().onCompletion { println("Done") }
//                .collect { value -> println(value) }
        //By replacing collect with launchIn we can launch a collection of the flow in a separate coroutine
        //, so that execution of further code immediately continues:
        simple().onEach { it ->
            println("Event Thread--${Thread.currentThread().name}-->$it")
        }.launchIn(this)
        println("Done")
    }
}

fun testFlow() {
    runBlocking {
        fun simpleFlow(): Flow<Int> = flow {
            for (i in 1..30) {
                delay(100)
                emit(i)
            }
        }.flowOn(Dispatchers.Default)//flowOn operator
        //限时执行
//        withTimeoutOrNull(200) {
//            simpleFlow().collect {
//                println(it)
//            }
//        }
        flowOf(1, 2, 3).collectLatest {
//            println("Collecting $it")
            delay(1)
            println(it) // Expect only 3 to be printed
        }
        val time = measureTimeMillis {
            simpleFlow()
                    .collectLatest { value -> // cancel & restart on the latest value
                        println("Collecting $value")
                        delay(300) // pretend we are processing it for 300 ms
                        println("Done $value")
                    }
        }
        println("Collected collectLatest in $time ms")

        //Flow builders
        flowOf(4, 5, 6)
                .map {//转换
                    it + 2
                }
                .filter {
                    it > 6
                }
                .take(2)//Size-limiting operators
                .collect {
                    println(it)
                }
        var times = measureTimeMillis {
            (10..12).asFlow()
                    .buffer()
                    .collect {
                        println(it)
                    }
        }
        println("Collected in $times ms")
    }
}

suspend fun simple(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

/**
 * 主线程死了 GlobalScope.launch就不会执行了。需要有个东西拖住它
 */
fun testSuspendFlow() {
    println("start before runBlocking")
    val launch = GlobalScope.launch {
        try {
            delay(1000L)
            println("run GlobalScope launch")
            val listOf = listOf(1, 2, 3)

            listOf.forEach {
                println("run listOf forEach ")
                delay(1000L)
                println(it)
            }
            println("after run GlobalScope launch")
        } catch (e: Exception) {
            println(" run GlobalScope launch Exception " + e.message)
        }

    }
//    launch.start()
    runBlocking {
        delay(10000L)
        println("ining runBlocking")
//        simple().forEach{
//            println("runBlocking listOf forEach ")
//            println(it)
//        }
    }
    println("after before runBlocking")
}

//This code outputs the same numbers, but it waits 100ms before printing each one.
fun testSequences() {
    runBlocking {
        fun simple(): Sequence<Int> = sequence {
            for (i in 1..3) {
                Thread.sleep(1000)
                yield(i)
            }
        }
        simple().forEach { it ->
            println(it)
        }
    }

}
