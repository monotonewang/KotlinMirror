package montotone.com.github.www.test_coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

//https://kotlinlang.org/docs/reference/coroutines/channels.html
//2020年10月13日11:14:23
fun main() {

//    testBasics()

//    testBuildingChannel()
//    testPipelines()
    testMultiple()
}

fun testMultiple() {
    runBlocking {
        var channel = Channel<String>()
        launch {
            sendString(channel, "foo", 200L);
        }
        launch {
            sendString(channel, "Bar!", 500L);
        }
        repeat(6) {
            println(channel.receive())
        }
        coroutineContext.cancelChildren()
    }
}

suspend fun sendString(channel: SendChannel<String>, s: String, time: Long) {
    while (true) {
        delay(time)
        channel.send(s)
    }
}

fun testPipelines() {
    runBlocking {
        val numbers = produceNumbers() // produces integers from 1 and on
        val squares = square(numbers) // squares integers
        repeat(5) {
            println(squares.receive()) // print first five
        }
        println("Done!") // we are done
        coroutineContext.cancelChildren() // cancel children coroutines
    }
}

fun testBuildingChannel() {

    runBlocking {
        produceSquares()
        buildChannel().consumeEach {
            println(it)
        }
        produce {
            for (x in 1..5) send(x + x)
        }.consumeEach { println(it) }
        println("Done")
    }
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (x in numbers) send(x * x)
}

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while (true) send(x++) // infinite stream of integers starting from 1
}

private fun CoroutineScope.buildChannel(): ReceiveChannel<Int> {
    return produce {
        for (x in 1..5) send(x + x)
    }
}

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) send(x + x)
}

fun testBasics() {
    runBlocking {
        val channel = Channel<Int>()
        launch {
            // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
            for (x in 1..5) channel.send(x * x)
            channel.close() // we're done sending
        }
// here we print five received integers:
        for (y in channel) {
            println(y);
        }
//        repeat(5) { println(channel.receive()) }
        println("Done!")
    }
}