package montotone.com.github.www.highfuncation

fun hello(s: String, d: Double): Boolean {
    return true
}


//多参数的函数变成单参数的 函数 叫做科理化

//fun curryHello(s:String):(y:Int)->(x:Double)->Boolean{
//
//}

fun hello(s:String)=fun(target:Double)=false


fun main(args: Array<String>) {
    val hello = hello("a", Double.MAX_VALUE)
    println(hello)


    val hello1 = hello("test")(Double.NaN)

    println(hello1)

}