package montotone.com.github.www.basic

import org.junit.Test

class TestVariables {

    @Test
    fun defin() {
        var a: Int = 1  // immediate assignment
        val b = 2   // `Int` type is inferred
        val c: Int  // Type required when no initializer is provided
        c = 3       // deferred assignment
        println("b=" + b + "c=" + c + "a=" + a)
        print(max(c, b))
        val aByte: Byte = Byte.MAX_VALUE
        val baByte: Byte = Byte.MIN_VALUE

        print("" + aByte + "b=" + baByte)


    }

    fun max(a: Int, b: Int) = if (a > b) a else b

    fun printProduct(arg1: String, arg2: String) {
//        val x = parseInt(arg1)
//        val y = parseInt(arg2)

        // Using `x * y` yields error because they may hold nulls.
//        if (x != null && y != null) {
//            // x and y are automatically cast to non-nullable after null check
//            println(x * y)
//        } else {
//            println("either '$arg1' or '$arg2' is not a number")
//        }
    }

    /**
     * 默认参数和具名参数
     */
    /**
     * 获取长方形面积
     */
    fun getRectArea(long: Float, width: Float): Float {
        return long * width
    }

    /**
     * 获取圆的周长
     */
    fun getRectCircle(PI: Double = Math.PI, r: Float): Double {
        return PI * r * 2
    }

    /**
     * 获取圆柱体体积
     */
    fun getCircleBall(PI: Float, r: Float, height: Float): Float {
        return PI * r * r * height
    }

    @Test
    fun testArea() {
        println(getRectArea(3.0f, 2.0f))
        //下面使用了具名参数
        println(getRectCircle(r = 2.0f))

    }


}