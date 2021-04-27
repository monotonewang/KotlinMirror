package montotone.com.github.www.structure

class TestFuncation {


    fun sum(args1: Int, args2: Int): Int {

        return args1 + args2
    }

    fun main(args: Array<String>) {
        println("In-testFuncation"+ minus(3, 1))





        var result=add(3,5)
        print(result)

        //函数表达式--把函数赋值给一个变量
        var i={x:Int,y:Int->x+y}
        println("funcation="+i(3,5))

        var j:(Int,Int)->Int={x,y->x+y}

        println(j(3,5))
    }







}

fun add(x:Int,y:Int):Int=x+y


fun minus(args1: Int, args2: Int): Int {

    return args1 - args2
}


//函数指针
val toLongValues=fun (args1: Int, args2: Int): Long= args1.toLong()

fun main(args: Array<String>) {
    println("testFuncation=="+ toLongValues(3, 1))
}