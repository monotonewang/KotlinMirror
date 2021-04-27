package montotone.com.github.www.basic.recursion

import org.junit.Test
import java.math.BigInteger

/**
 * 递归
 */
class TestRecursion {

    @Test
    fun testRecursion() {
        var result = BigInteger.ONE
        println(getRecursion2(BigInteger("5"), result))
        print(result)
//        println(getRecursion(1000000))
    }


    /**
     * 自定义递归代码
     */
    fun getRecursion(num: Int): Int {

        var numTemp = num
        //结果集
        var result = 1

        var firstCalc = false

        while (numTemp >= 1) {
            if (numTemp == 1) {
                result *= numTemp
            } else {
                if (!firstCalc) {
                    result = numTemp * (numTemp - 1)
                    firstCalc = true
                } else {
                    result *= (numTemp - 1)
                }
            }
            numTemp--
        }
        return result
    }


    /**
     * 计算大型int的递归
     */
    fun getRecursion(num: BigInteger): BigInteger {

        var result = BigInteger.ONE

        if (num == BigInteger.ONE) {
            result *= num
        } else {
            result = num * getRecursion(num - BigInteger.ONE)
        }

        return result

    }

    /**
     * 尾递归优化
     */
    tailrec fun getRecursion2(num: BigInteger, result: BigInteger): BigInteger {

        println("cal$num,result=$result")
        if (num == BigInteger.ONE) {
            return num
        } else {
            return getRecursion2(num - BigInteger.ONE, result * num)
        }

    }
}