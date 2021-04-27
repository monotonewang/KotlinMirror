package montotone.com.github.www.basic.testenum

import org.junit.Test

class TestEnum {
    @Test
    fun testRGB() {

        var color = ColorEnum.RED.getRgb()

        println(color)

    }


    @Test
    fun testEnum() {
        print(Week.xq1.ordinal)
    }
}

