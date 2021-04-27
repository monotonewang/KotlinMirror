package montotone.com.github.www.basic.testfilter

import org.junit.Test

class TestFilter {


    fun solveList(): String {


        val list = listOf<Int>(1,23,321321,12121,100)
        return list.filter { it % 3 == 0 }.map { "#$it" }.reduce { s1, s2 -> "$s1, $s2" }
    }

    @Test
    fun test() {
        val solveList = solveList()
        println(solveList)
    }




    interface Foo<out T : Any>  {
        fun foo(a: Int): T
    }


}


