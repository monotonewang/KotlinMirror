package montotone.com.github.www.highfuncation

val addX = { x: Int -> x + 5 }

val mutil = { x: Int -> x * 2 }

fun main(args: Array<String>) {
    println(mutil(addX(3)))


    val function = addX andThen mutil

    println(function(3))
}

infix fun <P1, P2, R> Function1<P1, P2>.andThen(function: Function1<P2, R>): Function1<P1, R> {
    return fun(p1: P1): R {
        return function.invoke(this.invoke(p1))
    }
}