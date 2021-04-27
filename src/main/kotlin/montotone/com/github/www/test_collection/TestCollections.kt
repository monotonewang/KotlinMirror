package montotone.com.github.www.test_collection

import java.lang.Exception

fun main() {
    testListSetMap();
//    testFilter()
//    testAny()
//    testFind()
//    testGroupBy()
//    testPartition()
//    testFlatMap()
//    testSorted()
}

private val mediaIdToChildren = mutableMapOf<String, MutableList<String>>()

fun testListSetMap() {
    val mutableList = mediaIdToChildren["a"];
    val rootList = mediaIdToChildren[mutableList] ?: mutableListOf()
    println(mutableList)
    println(rootList)
    var recommendedMetadata= listOf<String>("1","3")
    rootList += recommendedMetadata
    println(rootList)

    val numbers2 = listOf("one", "two", "three", "four")
//    numbers2.add("five") error

    val numbers = mutableListOf("one", "two", "three", "four")
    numbers.add("five")

    println(numbers)
    numbers.shuffle()//打乱东西的
    println(numbers)

    val doubled = List(3, { it * 2 })  // or MutableList if you want to change its content later
    println(doubled)

    var sets: MutableSet<String> = mutableSetOf("a", "b", "c", "d");
    sets.add("f");
    sets.add("c");
    for (i in sets) {
        print("i==$i")
    }
    println("xxxxx down map")
    var maps: MutableMap<Int, Int> = mutableMapOf(1 to 20, 30 to 2);
    for (i in maps) {
        print("i==$i")
    }
    println()
    println(maps.containsKey(1))

    val map = mapOf("key" to 42)
    val mapWithDefault = map.withDefault { k -> 50 }
    println(mapWithDefault)
    try {
        val value = map.getValue("anotherKey")
    } catch (e: Exception) {
        println(e.message)
    }
    val A = listOf("a", "b", "c")                  // 1
    val B = listOf(1, 2, 3, 4)                     // 1

    val resultPairs = A zip B //List<Pair<T, R>>
    println(resultPairs)

    val list = listOf(0, 10, 20)
    println(list.getOrElse(1) { "42" })    // 1
    println(list.getOrElse(10) { 42 })
}

fun testFilter() {
    val listOf = listOf(1, 2, 9, 3, 8, 3, 7)

    val map = listOf.map { it + 2 - 1 }

//    val filter = map.map {it.toDouble()}
    println(map)
    val filter1 = map.filter {
//        print("it=" + it.toString() + "large=" + (it.toString() > "3"))
        it > 3
    }
    println()
    filter1.forEach { print("filter=" + it) }


}

fun testAny() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val any = numbers.any { it > 10 };//判断里面元素是否有一个大于2的
    val count = numbers.count();
    val count1 = numbers.count { it > 2 }//获取里面元素是否有大于2的元素个数
    println(any)
    println(count)
    println(count1)
    val contains: Boolean = numbers.contains(1)
    println(contains)
    val lastIndexOf = numbers.lastIndexOf(5);
    println(lastIndexOf)
    val all = numbers.all(fun(i): Boolean {//判断里面元素都不等于2
        return i != 2
    })
    println(all)
    val none = numbers.none { it == 2 }//Returns `true` if no elements match the given [predicate].
    println(none)
}

fun testFind() {
    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")
    val find = words.find { it.startsWith("so") }
    println(find)
    val findLast = words.findLast { it.startsWith("so") }
    println(findLast)
}

data class User(val name: String, val phone: String)

fun testGroupBy() {
    val user = listOf<User>(User("Tom", "13634133426"), User("John", "18857880248"))
    var userName: Map<String, User> = user.associateBy { it.phone }//会转化成map
    val userNameMap = user.associateBy({ it.phone }, { "+86" + it.phone })//会转化成map {13634133426=+8613634133426, 18857880248=+8618857880248}
    println(userName);
    println(userNameMap);
    var mutableMap: MutableMap<String, User> = mutableMapOf();
    val associateByTo = user.associateByTo(mutableMap, { it.name });//第一个参数是接收map的参数
    val groupBy = user.groupBy { it.phone }//return Map<K, List<T>>
    println(associateByTo)
    println(groupBy)
}

/**
 * 分组 返回元祖
 */
fun testPartition() {

    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val partition = numbers.partition { it > 2 }
    println(partition)
    println(partition.first)
}

fun testFlatMap() {
    val numbers = listOf(1, 2, 3)
    val flatMap = numbers.flatMap {
        val listOf = listOf(it + 2)
        listOf
    }
    println(flatMap)//[3, 4, 5]

    val numbers2 = listOf(1, 2, 3)
    val empty = emptyList<Int>()

    println("Numbers: $numbers2, min = ${numbers2.minOrNull()} max = ${numbers2.maxOrNull()}") // 1
    println("Empty: $empty, min = ${empty.minOrNull()}, max = ${empty.maxOrNull()}")        // 2
}

fun testSorted() {
    var shuffled = listOf(5, 4, 2, 1, 3)     // 1
    val sorted = shuffled.sorted();
    println(sorted);
    val inverted = shuffled.sortedBy { -it } // 逆序
    println(inverted);
}