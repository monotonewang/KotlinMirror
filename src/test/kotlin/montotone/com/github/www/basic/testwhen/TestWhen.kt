package montotone.com.github.www.basic.testwhen

import montotone.com.github.www.basic.testenum.ColorEnum
import org.junit.Test

class TestWhen {

    @Test
    fun testWhenConnect() {
        val green = ColorEnum.GREEN


        val any = when (green) {//when支持使用任何对象
            ColorEnum.GREEN -> ColorEnum.GREEN.getRgb()
            ColorEnum.RED -> ColorEnum.RED.r
        }

        println(any)
    }

    @Test
    fun testWhen() {
        gradeStudent(10)
        gradeStudent(9)
        gradeStudent(7)
        gradeStudent(3)
        gradeStudent(1)
    }

    fun gradeStudent(score: Int) {
        when (score) {
            10 -> println("66666")
            8 -> println("优秀")
            7 -> println("还需努力")
            6 -> println("刚好及格")
            else -> println("不及格")
        }
    }
}