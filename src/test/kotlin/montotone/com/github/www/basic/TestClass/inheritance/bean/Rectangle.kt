package montotone.com.github.www.basic.TestClass.inheritance.bean

import java.util.*

data class Rectangle(var name: String, val height: Int, val width: Int) : Shape(name, height, width), Symmetry {


    val heightTemp = height.toString()


//    var isEmpty:Boolean get() = this.size.toInt()==0


    //父类的属性是val  自雷属性是var
    override var weight: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}


    //父类属性
    override var length: Int
        get() = super.length
        set(value) {}


    init {
        println("init-heightTemp-$heightTemp")
        name = "monotonewang"
    }


    constructor(name: String) : this("", 0, 0) {
    }

    //如果一个类有主构造函数，每个耳机构造函数都要，或直接或者间接通过另一个二级构造函数代理主构造函数
    //page-->55
    constructor(name: Int, address: Int) : this("", 0, 0) {

    }

    override fun testShape() {
        super.testShape()
    }

    override fun symmetryLength() {
        super<Shape>.symmetryLength()//调用shape的该方法
        super<Symmetry>.symmetryLength()

    }


    /**
     * 自定义访问器
     * 说明：需要描述的是类的属性，应该把它声明成属性， 不建议使用方法。
     */
    val isSquare: Boolean
        get() {
            return height == width
        }


    fun isSquarex(): Boolean {
        return height == width
    }


}

fun createRandomRecttangle(): Rectangle {
    val random = Random()
    return Rectangle("", random.nextInt(), random.nextInt())
}
