package montotone.com.github.www.basic.TestClass.inheritance.bean

class Customer {

    val simple: Int?

    constructor(name: String):this(name,0) {

    }

    constructor(name: String, height: Int)  {
        simple = 1

    }



}