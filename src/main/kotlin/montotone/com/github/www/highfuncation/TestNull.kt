package montotone.com.github.www.highfuncation

import java.io.BufferedReader
import java.io.FileReader

data class Person(val name: String, val age: Int) {
    fun work() {
        println("name=$name is working")
    }
}


fun main(args: Array<String>) {


    val person = findPerson()
//    println(person!!.name)

    val let = findPerson()?.let { person ->
        println(person.name)
        println(person.age)

        person.work()
    }

    println(let)

    val apply = findPerson()?.apply {
        println(name)
        println(age)

        work()
    }
    println(apply.toString())

    val with = with(findPerson(), {
        println(this?.name)
        println(this?.age)

        this?.work()
    })

    println(with)

    findPerson()?.also { it.work() }

    //kotlin 读取文件
    val readText = BufferedReader(FileReader("hello.txt")).readText()

    println("readText+$readText")

}

fun findPerson(): Person? {
    return Person("zhangsan", 21)
}