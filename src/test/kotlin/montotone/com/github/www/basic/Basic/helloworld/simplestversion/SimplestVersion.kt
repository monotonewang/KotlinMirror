package montotone.com.github.www.basic.Basic.helloworld.simplestversion

import org.junit.Test
import java.util.*

class SimplestVersion {


    @Test
    fun expression() {
        var maxNum=(2>211)?:2
        println(maxNum)
        var name="ssss"

        //字符串模板
        println("name=$name")
    }

    fun main(args: Array<String>) {
        if (args.size == 0) {
            println("Please provide a name as a command-line argument")
            return
        }
        println("Hello, ${args[0]}!")

        println("hello world!")
    }

    @Test
    fun readFromCommandLine() {

    }

    @Test
    fun test() {
        val args = Arrays.asList("")
        val language = if (args.size == 0) "EN" else args[0]
        println(when (language) {
            "EN" -> "Hello!"
            "FR" -> "Salut!"
            "IT" -> "Ciao!"
            else -> "Sorry, I can't greet you in $language yet"
        })
    }
}