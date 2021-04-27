package montotone.com.github.www.highfuncation

var string = "HelloWorld"

//返回函数
fun makeFun(): () -> Unit {
    var count = 0

    return fun() {
        println(++count)
    }
}

fun main(args: Array<String>) {
    val makeFun = makeFun()

    makeFun()
    makeFun()
    makeFun()
    makeFun()

    val addX = add(5)
    println(addX)
    val addX1 = addX(2)
    println(addX1)
}



//fun add(x:Int)=fun(y:Int)=x+y
fun add(x: Int): (Int) -> Int {

    data class Person(val name:String)

    return fun(y: Int): Int {
        return x + y
    }
}