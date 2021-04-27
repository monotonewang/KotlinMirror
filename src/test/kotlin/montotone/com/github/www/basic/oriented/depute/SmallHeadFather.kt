package montotone.com.github.www.basic.oriented.depute

/**
 * 委托代理关键字是by
 */
class SmallHeadFather : IWashBow by BigHeadSon{


    override fun wash() {
        println("我是大头爸爸，我赚了10块钱")
        BigHeadSon.wash()
        println("我是看着大头儿子把碗洗好了")
    }

}