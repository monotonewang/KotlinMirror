 package montotone.com.github.www.basic.oriented.wash

class WashMachine(var module: String, var size: Int) {


    var currentMode = 0

    fun wash() {
        open()
        when (currentMode) {
            0 -> println(module + "size=" + size + "=不能开始洗衣服 ")
            1 -> println(module + "size=" + size + "=发动机轻轻的转")
            else -> println(module + "size=" + size + "=请设置洗衣服模式")

        }
        if (currentMode in 1..99) {
            close()
        }
    }

    fun open() {
        println("open washMachine")
    }

    fun close() {
        println("close washMachine")
    }

    fun selectCurrentMode(i: Int) {
        currentMode = i
    }


}



fun WashMachine.setCurrentMode(i: Int) {

}

