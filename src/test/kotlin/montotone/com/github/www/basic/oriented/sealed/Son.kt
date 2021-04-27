package montotone.com.github.www.basic.oriented.sealed

/**
 * 印章类
 *
 * 小马
 * 骡子
 */
sealed class Son {

    fun sayHello() {
        println("sayhello")
    }

    class smallLv() : Son()
    class smallLuoZi() : Son()
}