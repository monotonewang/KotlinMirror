package montotone.com.github.www.structure

class TestOverloadFuncation {


    fun x() {

    }


    fun x(int: Int) {

    }

    //函数具有默认参数

    //    https://www.jianshu.com/p/72d1959a7c56
    @JvmOverloads
    fun xx(string: String = "hello"): String {

        return string
    }


}