package montotone.com.github.www.basic.testObject

import org.junit.Test

class TestObjecta {

    @Test
    fun testObject() {
        println(TestObject.a)
        println(AppConstant.a)
        println(testConst)
        println(AppConstantC.a)

        var a: String? = null

        a!!.let {
            println("x"?:"aa")
        }

        var test=a!!.run {
            println("x"?:"aa")
        }

    }
}