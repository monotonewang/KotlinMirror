package montotone.com.github.www.test_coroutines

import kotlinx.coroutines.*
import java.io.IOException
import java.lang.AssertionError

//https://kotlinlang.org/docs/reference/coroutines/exception-handling.html
//2020年10月13日13:46:23
fun main() {

//    testExceptions()
//    testCancelException()
//    testAggregation()
    testGetImage()

}

fun testGetImage() {
    runBlocking {
        val suspendGetImage = suspendGetImage()
        println(suspendGetImage)
    }
}

suspend fun suspendGetImage(): String? {
    var a: String? = null
    delay(1000L)
    val withContext = withContext(Dispatchers.IO) {
        a = "aaa";
//        a
        return@withContext a
    }
    return withContext;
//    return a;
}

fun testAggregation() {
    runBlocking {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("CoroutineExceptionHandler got $exception with suppressed ${exception.suppressed.contentToString()}")
        }
        val job = GlobalScope.launch(handler) {
            launch {
                try {
                    delay(Long.MAX_VALUE) // it gets cancelled when another sibling fails with IOException
                } finally {
                    println("first finally ArithmeticException start")
                    throw ArithmeticException() // the second exception
                }
            }
            launch {
                delay(100)
                println("second finally IOException start")
                throw IOException() // the first exception
            }
            delay(Long.MAX_VALUE)
        }
        job.join()
    }
}

fun testCancelException() {
    runBlocking {
        val job = launch {
            val child = launch {
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    println("Child is cancelled")
                }
            }
            yield()
            println("Cancelling child")
            child.cancel()
            child.join()
            yield()
            println("Parent is not cancelled")
        }
        job.join()
    }
}

fun testExceptions() {
    runBlocking {

        var handler = CoroutineExceptionHandler { _, exception ->
            run {
                println("CoroutineExceptionHandler got $exception")
            }
        }
        val launch = GlobalScope.launch(handler) {
            throw  AssertionError()
        }
        joinAll(launch)
    }

}
