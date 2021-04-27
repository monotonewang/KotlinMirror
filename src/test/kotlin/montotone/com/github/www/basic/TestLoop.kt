package montotone.com.github.www.basic

import org.junit.Test

class TestLoop {

    @Test
    public fun testFor() {
        testNums()
    }

    /**
     * 数组
     */
    fun testNums() {
//        var nums = 1..100 //[1,100]
        var nums = 1 until 100 //[1,100)
        var result = 0
        for (num in nums.reversed() step 2) {
            print("${num},")
            result = result + num
        }
        println("\n"+result+"count="+nums.count())


    }


}