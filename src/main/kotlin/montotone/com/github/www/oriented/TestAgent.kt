package montotone.com.github.www.oriented



//接口代理
class TestAgent{




}


interface Driver{
    fun drive()
}

interface Writer{

    fun writer()
}

open class Manager:Driver,Writer{
    override fun drive() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

//案例：    接口代理
//该类含义： 高级经理类， 不用自己开车和不用自己写作
//参数：    里面传递司机和作家
// 理解：   一个类的父类决定它是什么，继承接口代表它能做什么
class SeniorManager(val driver:Driver,val writer: Writer): Driver by driver,Writer by writer{

}

class CarDriver:Driver{
    override fun drive() {

        println("CarDriver drive" )
    }


}

class PdfWriter:Writer{
    override fun writer() {

        println("PdfWriter drive" )

    }

}

fun main(args: Array<String>) {
    val carDriver = CarDriver()
    val pdfWriter = PdfWriter()

    val seniorManager = SeniorManager(carDriver, pdfWriter)

    seniorManager.drive()
    seniorManager.writer()

}