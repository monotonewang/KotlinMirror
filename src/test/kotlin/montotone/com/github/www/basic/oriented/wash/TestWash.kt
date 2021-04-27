package montotone.com.github.www.basic.oriented.wash

import org.junit.Test

class TestWash {

    @Test
    fun testWash(){
        val washMachine = WashMachine("小天鹅", 12)
        washMachine.selectCurrentMode(1000)
        washMachine.setCurrentMode(1000)
        washMachine.wash()
    }

}