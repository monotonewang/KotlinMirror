package montotone.com.github.www.basic

import org.junit.Test

class TestNull {

    @Test
    fun testNull() {

        println(heat("水"))
        println(heat(null))
    }

    /**
     * 加上问号，代表参数可以为空
     */
    fun heat(string: String?): String {
        return "热" + string
    }

}