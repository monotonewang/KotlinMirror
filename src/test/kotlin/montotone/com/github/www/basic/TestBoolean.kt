package montotone.com.github.www.basic

//导入的不是包而是函数
import montotone.com.github.www.basic.TestClass.inheritance.bean.createRandomRecttangle

import org.junit.Test

class TestBoolean {

    @Test
    fun testBoolean() {
        var num1 = Math.sqrt(5.0) - Math.sqrt(4.0)
        var num2 = Math.sqrt(4.0) - Math.sqrt(3.0)
        println(num1 > num2)
        println("num1=" + num1)
        println("num2=" + num2)
        println(getPow(2, 3))
    }

    fun getPow(a: Int, b: Int): Double {
        return Math.pow(a.toDouble(), b.toDouble())
    }

    fun sayHello(string: String): String {
        return "SayHello" + string
    }

    fun checkAge(age: Int): Boolean {
        return age > 18
    }

    fun saveLog() {
        print("saveLog")
    }


    @Test
    fun testCreateReact(){

        val createRandomRecttangle = createRandomRecttangle()
        println("createRandomRecttangle"+createRandomRecttangle.toString()+createRandomRecttangle.isSquare)

    }

}