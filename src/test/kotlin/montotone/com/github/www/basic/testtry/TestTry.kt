package montotone.com.github.www.basic.testtry

import org.junit.Test


class TestTry {


    @Test
    fun testTry() {
       try {
           var a=1/0
       }catch (e :Exception){
           println("catch")
       }finally {
           println("finally")
       }
    }

}