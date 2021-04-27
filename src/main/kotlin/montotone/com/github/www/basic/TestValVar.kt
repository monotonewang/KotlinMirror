package montotone.com.github.www.basic


const val final_world:String="HelloWorld"//编译器常量

val final_world2:String="HelloWorld"
// 在static代码块进行赋值，可以在反射或者其他方式进行修改

var helloWorld:String= final_world


//可变参数
fun printAll(vararg messages: String) {
    for (m in messages) {
        for (x in m) {
            print(x + " ")
        }
        println("\n")
    }
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {  // 3
    for (m in messages) println(prefix + m)
}

fun main(args:Array<String>){
    helloWorld ="HelloChina"
    println(helloWorld)

    printAll("Hello", "Hallo", "Salut", "Hola", "你好")

    printAllWithPrefix(
            "Hello", "Hallo", "Salut", "Hola", "你好",
            prefix = "Greeting: "                                          // 4
    )

}

