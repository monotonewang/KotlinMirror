package montotone.com.github.www.oriented

import montotone.com.github.www.test_sealed.TestSealed

sealed class TestSealedClass{


    class Const(val number: Double) : TestSealedClass()

    class Sum(val e1: TestSealedClass, val e2: TestSealedClass) : TestSealedClass()

    object NotAumber : TestSealedClass()



}


//fun eval(expr:Expr):Double=when(expr){
//    is TestSealedClass.Const ->expr.number
//    is TestSealedClass.Sum ->eval(expr.e2)+eval(expr.e1)
//    is TestSealedClass.NotAumber -> Double.NaN
//}
//
//
//@Test
//fun testSealedClass() {
//    var double:Double=1.1
//    eval(Expr.Const(double))
//}