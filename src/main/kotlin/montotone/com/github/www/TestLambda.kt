package montotone.com.github.www


val printHello = {
    println("Hello")
}

val sum = { args1: Int, args2: Int -> args1 + args2 }
val sum2: (Int, Int) -> Int = { x, y -> x + y }

val action = { println("action") }
val action2: () -> Unit = { println("action2") }


/**
 * 定义简单的lambda函数
 */
fun twoAndThree(operation: (Int, Int) -> Int) {

    println("result=begin operation")

    val result = operation(2, 3)
    println("result=$result")
}


fun main(args: Array<String>) {

    println("sum="+sum(1, 2))
    println("sum funcation=$sum")

    val arrayListOf = arrayOf<String>("3", "2", "q")

    //这里的return是直接返回main函数
//    arrayListOf.forEach {
//        if (it == "q")return
//            println(it)
//    }
//
//
//    arrayListOf.forEach ForEach@{
//        if (it != "2")return ForEach@
//        println(it)
//    }

    testArgsForEach(arrayListOf)


    //和这个是一样的
//    sum.invoke(1,3)

    twoAndThree({ a, b -> a + b })
    twoAndThree { a, b -> a * b }
}

fun testArgsForEach(args:Array<String>){
    //第一种和第二种 结果一样 可以从字节码里面看出来
    args.forEach {
        if (it == "2")return
        println(it)
    }

    args.forEach ForEach@{
        if (it == "2")return ForEach@
        println(it)
    }


//    args.forEach ForEach@{
//        if (it == "2")return@ForEach
//        println(it)
//    }

    println("The End")

}