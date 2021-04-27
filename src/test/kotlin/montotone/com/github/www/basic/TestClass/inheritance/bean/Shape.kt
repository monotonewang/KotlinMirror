package montotone.com.github.www.basic.TestClass.inheritance.bean

open abstract class Shape(name: String, height: Int, width: Int) {


    open var length: Int = 21

    abstract val weight: Int

    open fun testShape() {

    }

     fun testFinalShape() {

    }

    open fun symmetryLength(){
        println("Shape-symmetryLength")
    }

}