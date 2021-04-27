package montotone.com.github.www.basic.Basic.testfor

import montotone.com.github.www.basic.Basic.testHashMap.TestHashMap
import org.junit.Test
import java.util.*
import java.util.function.Consumer

class TestFor {


    @Test
    fun testAt() {
        loop@ for (i in 1..100) {
            println("value=$i")
            if (i == 50) {
                break@loop
            }
        }

        loop@ for (i in 1..100) {
            for (j in 1..100) {
                println("value=$i+$j")
                if (i - j == 20) {
                    break@loop
                }
            }
        }

    }

    @Test
    fun foo() {
        val listOf = listOf<Int>(1, 2, 3, 65, 231)

        listOf.forEach lit@{
            if (it + 1 == 66) return@lit
            println("it$it")
        }

        listOf.forEach {
            if (it + 1 == 66) return@forEach
            println("it$it")
        }

        //可以使用函数表达式，替代匿名函数
        listOf.forEach(fun(value:Int){
            if (value + 1 == 66) return
            println("it$value")
        })

    }


    //自定义标签
//    fun outer(){
//        fun inner(){
//            return @outer
//        }
//    }




    @Test
    fun testFor() {
        val oneToX = 1..100//表示区间


        println("x" + oneToX.last)
        println("x" + oneToX.endInclusive)

        for (i in oneToX step 5) {
//            println(i)
        }

        for (i in oneToX.reversed() step 2) {
            println(i)
        }

    }

    @Test
    fun testMap() {
        val binaryReps = TreeMap<Char, String>()

        for (c in 'a'..'z') {

            val binary = Integer.toBinaryString(c.toInt())
            binaryReps[c] = binary
        }
        for ((letter, binary) in binaryReps) {
            println("$letter=$binary")
        }

        println(binaryReps.size)

    }

    @Test
    fun testList() {
        val arrayList = arrayListOf<String>("1", "2", "54")
        for ((a, b) in arrayList.withIndex()) {
            println("$a=$b")
        }
    }

    @Test
    fun testSA() {

        var fruits = listOf<Any>("banna", "xxxx", "a")

        fruits.forEach(Consumer { println(it) })

        TestHashMap()


    }

}
