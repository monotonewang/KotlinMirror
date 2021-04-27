package montotone.com.github.www.basic.oriented.equls

import org.junit.Test

class TestEqualss {

    @Test
    fun testEquals() {

        val a: Int = 12000;

        println(a === a);

        println(a == a)

        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        println(boxedA === anotherBoxedA)//false，值相等，对象地址不一样

        println(boxedA == anotherBoxedA)//true，值相等

        val b:Byte=127;

        val i:Int=b.toInt()
        println(i)

    }


}