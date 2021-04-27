package montotone.com.github.www.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Food {
    constructor() {
        println("Food constructors");
    }
}

class Cat {

    var name = "dom"

    constructor() {

    }

    constructor(food: Food) {

    }

    fun eat() {
        println("I am a cat,eat fish");
    }
}

private lateinit var food: Food;

/**
 * 当调用猫的属性和方法的时候回创建猫成员变量
 */
val cat by lazy {
    println("cat start by lazy");
//    Cat()
    Cat(food)
}

fun main(args: Array<String>) {

    GlobalScope.launch {
        food = Food()
        cat.eat();
        cat.name
    }

    Thread.sleep(10000)

}
