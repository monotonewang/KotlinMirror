package montotone.com.github.www.basic.Basic.helloworld.reading

fun main(args: Array<String>) {
    if (args.size == 0) {
        println("Please provide a name as a command-line argument")
        return
    }
    println("Hello, ${args[0]}!")

    println("hello world!")
}

