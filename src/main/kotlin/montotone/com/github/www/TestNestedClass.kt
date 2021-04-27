package montotone.com.github.www

class TestNestedClass{

}



//https://blog.csdn.net/carl1994/article/details/77866895

//Kotlin中的内部类与嵌套类的定义，跟Java并没有什么不同，区别在于在没有任何修
//饰的情况下，定义在另一个类内部的类将被默认为嵌套类，不持有外部类的引用，如果要将
//它声明为一个内部类，则需要加上inner修饰符，代码如下：

fun main(args:Array<String>){
    val demo=Outer.Nested().foo()

    println(demo)

    val demox=Outer().Inner().foo()

    println(demox)
}


class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }

    inner class Inner{
        fun foo()=bar
    }
}


