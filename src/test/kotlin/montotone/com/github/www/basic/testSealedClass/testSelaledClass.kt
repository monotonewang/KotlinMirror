package montotone.com.github.www.basic.testSealedClass

import org.junit.Test

sealed class Expr {

    class Const(val number: Double) : Expr()

    class Sum(val e1: Expr, val e2: Expr) : Expr()

    object NotAumber : Expr()




    fun eval(expr:Expr):Double=when(expr){
        is Const ->expr.number
        is Sum ->eval(expr.e2)+eval(expr.e1)
        is NotAumber-> Double.NaN
    }


    @Test
    fun testSealedClass() {
        var double:Double=1.1
        eval(Expr.Const(double))
    }


}

