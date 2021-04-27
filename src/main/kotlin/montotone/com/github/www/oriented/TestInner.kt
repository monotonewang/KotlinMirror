package montotone.com.github.www.oriented


class TestInner {

    val a: Int = 1

    inner class Inner {
        val a: Int = 5

        fun getValue() {
            println(a)
            //访问外部的成员变量
            println(this@TestInner.a)
        }

    }

}

interface OnSelfClickListener {
    fun onClick()
}

class View {


    private lateinit var onSelfClickListener: OnSelfClickListener

    fun setOnSelfClickListener(onSelfClickListener: OnSelfClickListener) {
        this.onSelfClickListener = onSelfClickListener
    }

    fun a(){
        onSelfClickListener.onClick()
    }


}


fun main(args: Array<String>) {
    TestInner().Inner().getValue()

   var view= View()

    view.setOnSelfClickListener(object : OnSelfClickListener {
        override fun onClick() {
            println("view onCLick callBack")
        }
    })


    view.a()


}