package montotone.com.github.www.basic.nullsafety

import com.sun.org.apache.xml.internal.security.Init
import org.junit.Test
import java.lang.reflect.Type

class TestNullSaftey {


    @Test
    fun testNon() {
        var nonNullType: Type?
        nonNullType = null


        var string: String?
        string = null

        //三元表达式
        var toDisplay: String = string ?: "sss"

        var notNull = string?.length ?: 0

        string?.let {
            print("string=" + string)
        }
        println(toDisplay + "notNull=" + notNull)

        string.run {
            println("run=" + string)
            return@run notNull
        }

        notNull.run {
            println("notNull run=" + string)
            return@run 3
        }
    }

    @Test
    fun testLet(): Unit {

        val testLetsInt = testLetsInt()

        println("testLetsInt=" + testLetsInt)

        // fun <T, R> T.let(f: (T) -> R): R { f(this)}
        "testLet".let {
            println(it)
            println(it)
            println(it)
            return Unit
        }

    }

    fun testLetsInt(): Int {
        // fun <T, R> T.let(f: (T) -> R): R { f(this)}
        "testLetsInt".let {
            println(it)
            println(it)
            println(it)
            return@testLetsInt 1
        }
    }


    @Test
    fun testFoo() {
        var intArray = IntArray(2, { _ -> 12 })
        var intArrayx = IntArray(3)

        val array2d = Array(3, { IntArray(3) { it -> 0 } })

        foo(intArray)
//        foo(array2d)

    }


    fun foo(ints: Array<IntArray>) {
        ints.forEach {
            //            if (it.get(1) == 0) return
            println(it.toString())
        }
    }

    fun foo(ints: IntArray) {
        ints.forEach {
            //            if (it == 0) return
            println(it)
        }
    }

    fun bar(ints: IntArray) {
        ints.forEach(fun(value: Int) {
            if (value == 0) return
            print(value)
        })
    }
}


