package montotone.com.github.www.basic

import org.junit.Test

class TestWith {

    @Test
    fun testWith() {
        val list: MutableList<String> = mutableListOf("A", "B", "C")
        val change: Any
        change = with(list) {
            add("D")
            add("E")
            this.add("F")
            size
        }
        println("list = $list")
        println("change = $change")

    }


    @Test
    fun testRun() {
        val list: MutableList<String> = mutableListOf("A", "B", "C")
        val change: Any
        change = list.run {
            add("D")
            add("E")
            this.add("F")
            size
        }
        println("list = $list")
        println("change = $change")

    }

    @Test
    fun testLet() {

        val list: MutableList<String> = mutableListOf("A", "B", "C")
        val change: Any
        change = list.let {
            it.add("D")
            it.add("E")
            it.size
        }
        println("list = $list")
        println("change = $change")

    }


}