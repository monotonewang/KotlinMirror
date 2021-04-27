package montotone.com.github.www.oriented

fun main(){
    testClass(); }


fun testClass() {

    val contact = Contact()
    val contact2 = Contact(1, "monotones@163.com");
    println(contact)
    println(contact2)

    val stack = mutableStackOf(0.62, 3.14, 2.7)
    println(stack)

    //多态
    val dog: Dog = Yorkshire()
    dog.sayHello()

    //#enum class
    val state = TestEnum.RUNNING                         // 2
    val message = when (state) {                      // 3
        TestEnum.IDLE -> "It's idle"
        TestEnum.RUNNING -> "It's running"
        TestEnum.FINISHED -> "It's finished"
    }
    println(message)
    println(state.getState())
}



fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

class Contact {

    var id: Int? = 0;
    var email: String? = "";

    constructor() {

    }

    constructor(id: Int, email: String) {
        this.id = id;
        this.email = email;
    }

    override fun toString(): String {
        return super.toString() + "id=" + this.id + "email=" + this.email;
    }
}

class MutableStack<E>(vararg items: E) {              // 1

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)        // 2

    fun peek(): E = elements.last()                     // 3

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

open class Dog {                // 1
    open fun sayHello() {       // 2
        println("wow wow!")
    }
}


class Yorkshire : Dog() {
    override fun sayHello() {
        println("wif wif!")
    }
}