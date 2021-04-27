package montotone.com.github.www.basic.TestGeneric

import org.junit.Test

class TestGeneric {

    class Box<T>(t: T) {
        var value = t


        override fun toString(): String {
            return "Box(value=$value)"
        }


    }

    //类似 ？extends Object  声明处变型
    abstract class Source<out T> {
        abstract fun nextT(): T
    }


    @Test
    fun testBox() {
        val box: Box<Int> = Box<Int>(1)

        println("box" + box)

    }

}