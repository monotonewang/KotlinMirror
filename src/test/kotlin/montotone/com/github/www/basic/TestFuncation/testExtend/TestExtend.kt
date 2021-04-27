package montotone.com.github.www.basic.TestFuncation.testExtend

import org.junit.Test

/**
 * 扩展函数
 *   :扩张函数是被静态分发的。
 */
fun MutableList<Int>.swap(x: Int, y: Int) {
    val temp = this[x]
    this[x] = this[y]
    this[y] = temp


}


class TestExtend {

    @Test
    fun test() {
        val mutableListOf = mutableListOf<Int>(2, 2, 2, 10);
        mutableListOf.swap(0, 3)

        println("mutableListOf\n$mutableListOf")
        println("mutableListOf\n${mutableListOf.lastIndex}")
    }
}