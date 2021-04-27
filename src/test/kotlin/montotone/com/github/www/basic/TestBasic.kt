package montotone.com.github.www.basic

import org.junit.Test

class TestBasic {

    @Test
    fun testKotlinMain() {
        print("Hello Kotlin")
    }

    @Test
    fun definingFuncations(){
        print(sum(1,2));
        print(sum1(1,2));
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum1(a: Int, b: Int) = a + b


}