package montotone.com.github.www.basic

class TestFor {

}

fun main(args: Array<String>) {
    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {                               // 1
        println("Yummy, it's a $cake cake!")
    }
    for (i in 0..10) {
        print("i=$i")
    }
    println()
    for (i in 0..10 step 3) {
        print("i=$i")
    }
    println()
    for (i in 10 downTo 2) {//i=10i=9i=8i=7i=6i=5i=4i=3i=2
        print("i=$i")
    }
    println()
    for (i in 'z' downTo 'a' step 2) {
        print("i=$i")
    }
    println()
    var x = 2;
    if (x !in 6..10) {
        println("x is not in range")
    }

    //#Equality Checks
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println(authors == writers)   // 1 first ignore element order
    println(authors === writers)  // 2

    //#Conditional Expression
    fun max(a: Int, b: Int) = if (a > b) a else b         // 1

    println(max(99, -42))
}
