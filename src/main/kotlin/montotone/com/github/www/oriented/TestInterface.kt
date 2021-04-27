package montotone.com.github.www.oriented


interface InputDevice {


    //和java不同的地方----成员常量 没有初始值
    val name: String

    var namex: String


    //和java不同的地方----kotlin 方法有默认实现
    fun input(event: Any) {
        println("event input")
    }
}


interface UsbInputDevie : InputDevice

class UsbMouse : UsbInputDevie {


    override val name: String
        get() = "UsbMouse" //To change initializer of created properties use File | Settings | File Templates.
    override var namex: String
        get() = "UsbMousex" //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun input(event: Any) {
        super.input(event)

        println("UsbMouse input")
    }
}

interface BlueToothDevie : InputDevice

class BlueTooth : BlueToothDevie {

    override var namex: String
        get() = "BlueToothX" //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override val name: String
        get() = "BlueTooth" //To change initializer of created properties use File | Settings | File Templates.

    override fun input(event: Any) {
        super.input(event)
        println("BlueTooth input")
    }
}

class Computer {

    fun addInputDevice(inputDevice: InputDevice) {
        println("addInputDevice-------------${inputDevice.name + "namex=" + inputDevice.namex}")
    }
}

fun main(args: Array<String>) {
    val computer = Computer()
    computer.addInputDevice(UsbMouse())

    println("----------------------")
    println("----------------------")


    computer.addInputDevice(BlueTooth())
}


//InputDevice实现类
class SubInteIrface(override val name: String, override var namex: String) :InputDevice{}