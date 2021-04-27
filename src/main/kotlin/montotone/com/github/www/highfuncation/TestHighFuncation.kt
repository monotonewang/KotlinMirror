package montotone.com.github.www.highfuncation

import sun.security.provider.certpath.Vertex

class TestHighFuncation {


}

//kotlin 别名
typealias MyHandler = Sample

//Invoking a function type instance
val stringPlus: (String, String) -> String = String::plus

fun main(args: Array<String>) {
    println("Hello, ".plus("Kotlin"));
    println(stringPlus("Hello, ", "world!"))

    val list = listOf(1..5, 2..5, 3..5)


//    list.forEach { println(it) }

    list.map { println(it) }

//    list.flatMap { intRange -> intRange.map { println(it) } }

//    list.map { it.map { println(it) } }


    val flatMap = list.flatMap { it }
    println(flatMap.reduce { acc, intRange -> acc + intRange })


//    print(factory(4))


//    5+1+2+3=11

    val fold = (1..3).map {
        factory(it)
    }.fold(5) { acc, i -> acc + i }

    print(fold)

    val foldX = (1..3).map { factory(it) }.fold(StringBuilder()) { acc, i -> acc.append(i).append(",") }


    println(foldX)
    foo(baz = 1)
    foo(strings = *arrayOf("a", "b", "c"))
    foo(strings = arrayOf("a", "b", "c"))

    Sample().foo()


    println(sumNum(20))
    println(sumNumNew(20))

    val items = listOf(1, 2)
    val runCatching = items.filter {
        it > 0
    }.forEach {
        println("filter=${it}")
    }.runCatching {
        1 / 0
        println("runCatching=${this}")
    }

    println("runCatching.isSuccess=${runCatching.isSuccess}");

    //lambda写法
    items.fold<Int, Int>(0, { acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        return@fold result
//         result
        //两种写法效果一致
    }
    )
    //普通写法
    items.fold<Int, Int>(2, fun(x: Int, y: Int): Int {
        print("acc = $x, i = $y, ")
        val result = x * y
        println("result = $result")
        return result
    }
    )
    val sum = { x: Int, y: Int -> x + y };
    println(sum(2, 1))
    println(Sample().sum(1, 2))

}


fun factory(int: Int): Int {

    if (int == 0) return 1

    return (1..int).reduce { acc, intRange -> acc * intRange }

}

/**
 * 默认参数
 */
fun foo(bar: Int = 0, baz: Int) {
    println("bar=" + bar + "baz=${baz}");
}


fun foo(vararg strings: String) {
    for (i in strings) {
//        print(i.indices+"=" + i);
//        print(i.indices);
        print(i);
    }
    println();

}

class Sample {
    fun foo() {
        println("Foo")
    }

    fun sum(x: Int, y: Int): Int {
        return x + y;
    }
}

//fun dfs(graph: Graph) {
//    fun dfs(current: Vertex, visited: MutableSet<Vertex>) {
//        if (!visited.add(current)) return
//        for (v in current.neighbors)
//            dfs(v, visited)
//    }
//
//    dfs(graph.vertices[0], HashSet())
//}
//递归
fun sumNum(n: Int): Int {
    if (n == 1) {
        return 1;
    }
    return n + sumNum(n - 1)
}

//kotlin 尾递归
tailrec fun sumNumNew(n: Int): Int {
    return if (n == 1) 1; else n + sumNumNew(n - 1);
}

//A higher-order function is a function that takes functions as parameters, or returns a function.
fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}