package montotone.com.github.www.basic.TestCopy

import montotone.com.github.www.basic.TestClass.inheritance.bean.Rectangle
import org.junit.Test

class TestCopy {

    /**
     * 复制对象
     */
    @Test
    fun testCopyRect() {
        val rectangle = Rectangle("jack", 41, 212)


        //改变高度值
        val oldRectangle=rectangle.copy(height = 25)



        println("rectangle$rectangle\noldRectangle=$oldRectangle")
    }

}