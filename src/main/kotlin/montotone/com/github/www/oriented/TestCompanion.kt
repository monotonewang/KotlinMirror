package montotone.com.github.www.oriented

import java.util.*


class Latitude(val double: Double) {


    companion object {

        var string: String = "helloKotlin"

        @JvmField
        var age: Int = 2


        fun toDouble(): Double {
            return Random().nextDouble()
        }

        @JvmStatic
        fun toFloat(): Float {
            return Random().nextFloat()
        }
    }

}

fun main(args: Array<String>) {


    val toDouble = Latitude.Companion.toDouble()

    println(toDouble)

    println(Latitude.toDouble())
}


