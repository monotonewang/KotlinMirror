package montotone.com.github.www.basic.TestLambda

import org.junit.Test

class TestLambda {

    @Test
    fun defineSum() {

        val sum = { x: Int, y: Int -> x + y }

        val sum2: (Int, Int) -> Int = { x, y -> x + y }

        val action = { println("action") }
        val action2: () -> Unit = { println("action2") }
    }


    /**
     * 定义简单的lambda函数
     */
    fun twoAndThree(operation: (Int, Int) -> Int) {

        println("result=begin operation")

        val result = operation(2, 3)
        println("result=$result")
    }

    @Test
    fun testSum() {
        twoAndThree { a, b -> a + b }
        twoAndThree { a, b -> a * b }
    }

    /**
     * 定义以lambda为参数的buildString()
     */
    fun buildString(builerAction: (StringBuilder) -> Unit): String {
        val sb = StringBuilder()
        builerAction(sb)
        return sb.toString()
    }

    /**
     * 重新定义以带接受者的lambda为参数的buildString
     */
    fun buildStringx(builerAction: StringBuilder.() -> Unit): String {
        val sb = StringBuilder()
        builerAction(sb)
        return sb.toString()
    }

    @Test
    fun testBuildString() {
        val buildString = buildString {
            it.append("hello")
            it.append("\"world")
        }

        println(buildString + "\n")

        val buildStringx = buildStringx {
            append("hello")
            append("\"world")
        }

        println(buildStringx)
    }

}