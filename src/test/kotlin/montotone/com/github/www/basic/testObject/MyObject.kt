package montotone.com.github.www.basic.testObject

class MyObject{


}

object TestObject {//默认是单例

    var a = "object TestObject"
}

const val testConst="testConst"

interface AppConstant{

    companion object {

        val a = "companion object"
    }
}

class AppConstantC{

    companion object {

        val a = "AppConstantC object"
    }
}