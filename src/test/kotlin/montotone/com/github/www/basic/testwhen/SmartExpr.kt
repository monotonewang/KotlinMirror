package montotone.com.github.www.basic.testwhen

import org.junit.Test
import sun.security.provider.Sun

class SmartExpr {


    class Num(var value: Int) : Expr
    class Sum(var left: Expr, val right: Expr) : Expr


    fun eval(e: Expr): Int {
        if (e is Sum) {//用 is 判断一个变量是否属于某个类型 instanceOf
            return eval(e.left) + eval(e.right)
        } else if (e is Num) {
            return e.value
        }
        throw IllegalArgumentException("UnKnowException")

    }

    fun whenEval(e: Expr): Int {

        val i = when (e) {
            is Sum -> whenEval(e.left) + whenEval(e.right)
            is Num -> e.value
            else -> throw IllegalArgumentException("UnKnowException")
        }
        return i
    }


    @Test
    fun testEval() {

        val eval = eval(Sum(Num(1), Num(3)))
        println(eval)

        val evalwhen = whenEval(Sum(Num(1), Num(3)))
        println(evalwhen)
    }

}



