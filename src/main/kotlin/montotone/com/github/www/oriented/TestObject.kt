package montotone.com.github.www.oriented



//public final class TestObject extends FatherClass implements OnClickListener {

object TestObject : FatherClass(), OnClickListener {


    override fun onClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun talk() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    val name by lazy { "helloWorld" }

    lateinit var age: MyAge

    class MyAge {

    }


}

abstract class FatherClass {
    abstract fun talk()
}


interface OnClickListener {
    fun onClick()
}
