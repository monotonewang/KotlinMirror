package montotone.com.github.www.oriented

import montotone.com.github.www.PoKo


@PoKo
data class Country(val id: Int, val name: String)

//allOpen noArg



class City(val id: Int, val name: String)

data class User(val name: String)


fun main(args: Array<String>) {
    val china = Country(1, "china")

    println(china)

    val (id, name) = china

    println(id)
    println(name)

    var user = User("john");
    println(user)
    println(user.copy())
    println(user.copy("tom"))
    println(user.toString())
    println(user.name)
}