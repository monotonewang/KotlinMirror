package montotone.com.github.www.scoped_funcation

fun main() {
    testLet()
}

/**
 * apply和also 返回引用者本身
 * let和run 返回最后一行
 */
fun testLet() {
    var str: String? = null;
    var tempLet = "test"?.let {
        println(it.isEmpty())
        it;
    }

    println("tempLet=${tempLet}")

    str?.let {
        println(it)
    }
    str = "kotlin"
    //run let区别是 run传递是this,可以直接调用调用者方法
    var temp = str?.run {
        println("str=${str}")
        println("str=${isEmpty()}")
    }
    println("temp=${temp}")

    var withTemp = with(str, {
        println(str.length)
        str.length
//        return@with str
    })
    println("withTemp=${withTemp}")

    val alsoStr: String = str?.also {
        println("str=${it.isEmpty()}")
        return@also
    }
    println("alsoStr=${alsoStr}")

    val applyStr: String = str?.apply {
        println("str=${isEmpty()}")
    }
    println("applyStr=${applyStr}")

}