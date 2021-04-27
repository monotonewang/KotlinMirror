package montotone.com.github.www.basic.TestClass.inheritance.bean

import org.junit.Test

class TestRectangle{


    @Test
    fun testRect(){
        val rectangle=Rectangle(41,212)
        val square = rectangle.isSquare
        val squarex = rectangle.isSquarex()


        println("square$square\nsquarex=$squarex")
    }

    @Test
    fun testCreateReact(){

        println(createRandomRecttangle().isSquare)

    }


}
