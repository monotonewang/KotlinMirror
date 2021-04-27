package montotone.com.github.www.test_object

class Student {

    var name: String
        get() = field
        set(value) {
            field = value+"-"+value
        }

    constructor() {
        this.name = "tom";
    }

    constructor (name: String, age:Int) : this(name) {
        this.name = name;
    }


    constructor(name: String) {
        this.name = name;
    }

    class Boy {

    }

    inner class Girl {

        fun speak():String{
            return this@Student.name+" is a girl speak"
        }
    }
}

object MyObject {

    //同一个student
    val s1: Student by lazy {
        Student()
    };

    /**
     * 调用一次创建一个新的对象
     */
    fun getStudent(): Student {
        return Student()
    }
}

fun main() {
//    testObject()
    testInner()
}

//内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
private fun testInner() {
    val girl = Student().Girl()
    println(girl.speak())
    var s1=Student();
    val studentName = s1.name;
    s1.name="lily";
    val boy = Student.Boy();
    println(s1.name)
}

private fun testObject() {
    var s1 = Student()
    var s2 = Student()

    println(s1)
    println(s2)

    var o1 = MyObject
    var o2 = MyObject
    println(o1)
    println(o2)
    var so1 = o1.getStudent();
    var so2 = o2.getStudent();
    println(so1)
    println(so2)
    println("MyObject student")
    println(o1.s1)
    println(o2.s1)
}