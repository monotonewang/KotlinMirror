package montotone.com.github.www

import montotone.com.github.www.oriented.TestEnum
import javax.naming.event.ObjectChangeListener




fun main(args: Array<String>) {

    var isInput = false
    while (!isInput) {
        println("please input first number")
        var num1 = readLine()
        try {
            val toInt = num1!!.toInt()
            println("result" + toInt)
            isInput = true
        } catch (e: Exception) {
            println("please input  number")
        }
    }





}


