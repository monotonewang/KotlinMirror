package montotone.com.github.www.test_coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.selects.SelectInstance
import kotlin.system.measureTimeMillis

//createTime 2020年10月12日10:14:17
//https://kotlinlang.org/docs/reference/coroutines/basics.html
fun main() {
//    testBasic()
//    testJoin();
    testScope()
//    testSuspend()
//    testCancel()
//    testTryCatch()
//    testTryCatchContext()
//    testWithTimeOut()
//    testComposing()
//    testLaunch()
//    testJumpThreads()
//    testChildCoroutine()
//    testMoreParams()
}

fun testMoreParams() {
    runBlocking {
        launch(Dispatchers.Default + CoroutineName("test")) {
            println("I'm working in thread ${Thread.currentThread().name}")
        }
        val launch = launch(context = Dispatchers.Default + CoroutineName("test")) {
            println("I'm working in thread ${Thread.currentThread().name}")
        }
        println(launch.key)
    }

}


/**
 * 说明协同执行的代码不会被cancel打断
 */
fun testChildCoroutine() {
    runBlocking {
        // launch a coroutine to process some kind of incoming request
        val request = launch {

            // it spawns two other jobs, one with GlobalScope
            val launch = GlobalScope.launch {
                println("job1: I run in GlobalScope and execute independently! Thread name=" + Thread.currentThread().name)
                delay(1000)
                println("job1: I am not affected by cancellation of the request")
            }
            // and the other inherits the parent context
            launch {
                delay(100)
                println("job2: I am a child of the request coroutine, Thread name=" + Thread.currentThread().name)
                delay(1000)
                println("job2: I will not execute this line if my parent request is cancelled")
            }
            val async = async(CoroutineName("testAsync")) {
                delay(100)
                println("async job3: I am a child of the request coroutine, Thread name=" + Thread.currentThread().name)
                delay(1000)
                println("async job3: I will not execute this line if my parent request is cancelled! Thread name=" + Thread.currentThread().name)
            }
            async.cancel(CancellationException("async cancel")) //cancel了 await 之后 不报异常 ，正常执行！！！！！！！奇怪
            //下面的await代码可以挂起这个launch 导致 最后 line 6执行到这 async后面
            async.await()
//            delay(1)
//            async.join()
            println("request: I'm done and I don't explicitly join my children that are still active") // line 6
        }
        println("main: start before delay option")
        delay(500)
//        request.join()
//        request.cancel() // cancel processing of the request
        delay(1000) // delay a second to see what happens
        println("main: Who has survived request cancellation?")
    }
}

fun testJumpThreads() {
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                println("Started in ctx1")
                withContext(ctx2) {
                    println("Working in ctx2")
                }
                println("Back to ctx1")
            }
        }
    }
}

//1 2 3 4 5 6 7 8

fun testLaunch() {
    runBlocking {
        launch { // context of the parent, main runBlocking coroutine
            println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
            println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
            println("Default               : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
            println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
            delay(500)
            println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
        }
        val a = async {
            println("async      : in thread ${Thread.currentThread().name}")
            println("I'm computing a piece of the answer")

            6
        }

        println("after async= ${a}---${a.await()}--${a.isCompleted}--${a.isCancelled}--${a.isActive}")
    }

}

fun testComposing() {
//    runBlocking {
//        val time = measureTimeMillis {
//            val one = doSomethingUsefulOne()
//            val two = doSomethingUsefulTwo()
//            println("The answer is ${one + two}")
//        }
//        println("Completed in $time ms")
//    }

    //This is twice as fast, because the two coroutines execute concurrently.
    // Note that concurrency with coroutines is always explicit.
    //async can be made lazy by setting its start parameter to CoroutineStart.LAZY.
    runBlocking {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.ATOMIC) { doSomethingUsefulOne1() }
            val two = async(start = CoroutineStart.ATOMIC) { doSomethingUsefulTwo2() }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
}

suspend fun doSomethingUsefulOne1(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo2(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 29
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}


fun testWithTimeOut() {
    runBlocking {
//        withTimeout(1300L) {
//            repeat(1000) { i ->
//                println("I'm withTimeout sleeping $i ...")
//                delay(500L)
//            }
//        }

        val result = withTimeoutOrNull(1300L) {
            repeat(1000) { i ->
                println("I'm withTimeoutOrNull sleeping $i ...")
                delay(500L)
            }
            "Done" // will get cancelled before it produces this result
            return@withTimeoutOrNull
        }
        println("Result is $result")

    }
}

fun testTryCatchContext() {
    runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {

                withContext(NonCancellable) {
                    println("job: I'm running finally")
                    delay(1000L)
                    println("job: And I've just delayed for 1 sec because I'm non-cancellable")
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }
}

fun testTryCatch() {
    runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                println("job: I'm running finally")
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }
}

fun testCancel() {
    runBlocking {
        println("Thread Name=" + Thread.currentThread().name)
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            println("launch Thread Name=" + Thread.currentThread().name)
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) { // computation loop, just wastes CPU
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }
}

//Cancellation and Timeouts
fun testSuspend() {
    var launch: Job? = null;
    runBlocking {
        repeat(1_0) {
            launch = launch { doWorld() }

        }
        println("Hello,")
        Thread.sleep(2000L)
        println("main: I'm tired of waiting!")
        launch?.cancel()
        launch?.join() // waits for job's completion
        println("main: Now I can quit.")

//        coroutineScope {
//        }
    }


}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

fun testBasic() {

    println("before runBlocking=" + Thread.currentThread().name)
    runBlocking {
        println("in runBlocking=" + Thread.currentThread().name)
        GlobalScope.launch {
            println("start  GlobalScope.launch=" + Thread.currentThread().name)
            withContext(Dispatchers.IO) {
                delay(2000L)
                println("start coroutineScope=" + Thread.currentThread().name)
            }
            println("after coroutineScope=" + Thread.currentThread().name)
        }
    }
    println("after runBlocking=" + Thread.currentThread().name)

    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!" + System.currentTimeMillis() / 1000) // print after delay
    }
    println("Hello," + System.currentTimeMillis() / 1000) // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive

    runBlocking {
        delay(1000L)
        println("runBlocking=" + System.currentTimeMillis() / 1000)
    }
    Thread.sleep(2000L)
    println("After runBlocking=" + System.currentTimeMillis() / 1000)
}

/**
 * Because of that difference, runBlocking is a regular function and coroutineScope is a suspending function.
 */
fun testJoin() {
    var job = GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!" + System.currentTimeMillis() / 1000) // print after delay
    }
    runBlocking {
        job.join()
//        delay(1000L)
        println("runBlocking=" + System.currentTimeMillis() / 1000)
    }
    println("Hello," + System.currentTimeMillis() / 1000) // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive


    Thread.sleep(2000L)
    println("After runBlocking=" + System.currentTimeMillis() / 1000)

}


fun testScope() {
    runBlocking {
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // Creates a coroutine scope
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(300L)
            println("Task from coroutine scope") // This line will be printed before the nested launch
        }

        println("Coroutine scope is over") // This line is not printed until the nested launch compl
    }
}

