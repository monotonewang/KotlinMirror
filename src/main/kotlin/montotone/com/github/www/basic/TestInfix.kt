package montotone.com.github.www.basic


fun main(){
    infixFunctions();
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()

    infix fun likes(other: Person) {
        likedPeople.add(other)
    }  // 6

    override fun toString(): String {
        return likedPeople.toString() + "name=" + this.name
    }
}

private fun infixFunctions() {
    //中缀表达式
    infix fun Int.times(str: String) = str.repeat(this)        // 1
    println(2 times "Bye ")

    //元组
    val pair = "Ferrari" to "Katrina"                          // 3
    println(pair)

    val pair2 = 1 to 2;
    println(pair2)

    infix fun String.onto(other: String) = Pair(this, other)   // 4
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
    sophia likes claudia
    println(sophia)
    println(claudia)
}