package montotone.com.github.www.basic

import org.junit.Test
import java.util.*

class TestList {

    @Test
    fun testList() {
        getList()
        getMap()
    }

    @Test
    fun testNullList(){
       val nullableList :List<Int?> = listOf(1,2,null,2,5)

        val intList:List<Int> = nullableList.filterNotNull()



        println(intList)
        println(intList.isEmpty())
        println(intList.contains(1))
        println(intList.get(1))
        println(intList.indexOf(2))
        println(intList.lastIndexOf(2))
    }

    fun getList() {
        var lists = listOf("a", "b", "c");
        for (string in lists.reversed()) {
            println(string)
        }

        for ((string, e) in lists.withIndex()) {
            println("" + string + "e=" + e)
        }
    }

    fun getMap() {
        var map = TreeMap<String, String>()
        map.put("a", "aa")

        for (mapx in map){
            print(mapx.value)
        }
    }

}