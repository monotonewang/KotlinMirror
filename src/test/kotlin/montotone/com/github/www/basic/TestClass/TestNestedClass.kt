package montotone.com.github.www.basic.TestClass

import org.junit.Test


//https://blog.csdn.net/carl1994/article/details/77866895

class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }

    inner class Inner{
        fun foo()=bar
    }
}


class TestNestedClass{

    @Test
    fun testNested(){
        val demo=Outer.Nested().foo()

        println(demo)
    }


    @Test
    fun testInner(){
        val demo=Outer().Inner().foo()

        println(demo)
    }

}