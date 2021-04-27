package montotone.com.github.www.basic

fun main() {
    testWhen(Object());
    testWhen("Hello");
    testWhen(1);
}

fun testWhen(obj: Any) {
    when (obj) {
        1 -> println("one")
        "hello" -> println("greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unkown");
    }
}