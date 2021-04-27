package montotone.com.github.www.basic.oriented.extends

import org.junit.Test

class TestStudent() {

    @Test
    fun testStudent() {
//        val extends = Person()
//        extends.action()
        val student = Student("张三")
        student.eat()
        student.action()
    }


}