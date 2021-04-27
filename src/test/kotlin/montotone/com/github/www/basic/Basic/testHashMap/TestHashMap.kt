
@file:JvmName("TestHashMapx")
package montotone.com.github.www.basic.Basic.testHashMap

import montotone.com.github.www.basic.oriented.name

import org.junit.Test

class TestHashMap {



    @Test
    fun testHashMap() {
        val hashMapOf = hashMapOf<Int, String>(1 to "fas", 2 to "fdas", 3 to "sdafsa")
        print(hashMapOf.entries)
        print(hashMapOf.isEmpty())
        print(hashMapOf.size)
        print(hashMapOf.count())

        println(name)

    }




}