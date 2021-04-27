package montotone.com.github.www.basic.oriented.extends

abstract open class Person (var name:String){

    val chactor: String = "性格内向"

    abstract fun eat()

    open fun action() {
        println("公共场合喜欢大声喧哗")
    }
}