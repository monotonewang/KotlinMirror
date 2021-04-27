package montotone.com.github.www.oriented

class TestExtendFuncation {
    //扩展方法

    fun main(args: Array<String>) {

    }
}

fun main(args: Array<String>) {
    println("abc".times(2))
    println("abc" * 10)

    println("a".string)
}


operator fun String.times(int: Int): String {
    val stringBuilder = StringBuilder()

    for (int in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

//扩展属性 本质和扩展方法一致
val String.string: String
    get() = "test"