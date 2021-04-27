package montotone.com.github.www.basic.testLimitThis

class TestLimitThis {


}

class A {
    inner class B {
        fun Int.foo() {
            val a = this@A
            val b = this@B

            val c = this
            val c1 = this@foo
            val funLit = lambda@ fun String.() {
                val d = this
            }

            val funLit2 = { s: String ->
                val d1 = this
            }

        }
    }
}