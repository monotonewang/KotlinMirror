package montotone.com.github.www.oriented


abstract class TestAbstract {


    var a = 1;
    var b = null;

    open fun hello() {
        println("hello")
    }

    fun say() {
        println("say")
    }

    abstract fun walk()

}

class SubClass : TestAbstract() {

    override fun hello() {
        super.hello()
    }

    override fun walk() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}