package montotone.com.github.www.basic.TestLazy

import org.junit.Test
import kotlin.properties.Delegates

class TestLazy {

    val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }

    @Test
    fun testLazy() {
        println("lazyValue=" + lazyValue)
    }

    class User {
        var name: String by Delegates.observable("test") { property, oldValue, newValue ->
            println("$property->$oldValue->$newValue")
        }

        var address: String by Delegates.vetoable("test") {
            property, oldValue, newValue ->  println("$property->$oldValue->$newValue")
             false
        }
    }

    @Test
    fun testLazyUser() {
        val user =User()
        user.name="first"
        user.name="second"
        user.address="beijing"
        user.address="shanghai"
    }


}