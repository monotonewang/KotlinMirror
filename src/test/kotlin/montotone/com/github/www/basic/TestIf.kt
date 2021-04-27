package montotone.com.github.www.basic

import org.junit.Test

class TestIf {

    @Test
    fun testIf() {
        val big = getBig(3, 5)
        println(big)
    }

    fun getBig(a: Int, b: Int): Int {
        if (a > b) return a else return b
    }
}