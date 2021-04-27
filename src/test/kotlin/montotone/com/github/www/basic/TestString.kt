package montotone.com.github.www.basic

import org.junit.Test

/**
 * 字符串模板
 */
class TestString {

    @Test
    fun testString() {
        getPlace("中山公园")
        stringEquals("zhangSan", "zhangsan")
    }


    private fun getPlace(placeName: String): String {
        var temple = "今天去${placeName}玩${placeName.length}"
        println(temple)
        return ""
    }

    fun stringEquals(string1: String, string2: String): String {
        print(string1 == string2)
        print(string1.equals(string2))
        print(string1.equals(string2, true))
        return ""
    }

    /**
     * 字符串和数字的转化
     */
    @Test
    fun testWorld() {
        var a="14"
        var b=13
        a=b.toString()
        println(a)
        b=a.toInt()
        println("b="+b)
    }
}