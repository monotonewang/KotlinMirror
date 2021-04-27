package montotone.com.github.www.basic.oriented.extends

class Student(name: String) : Person(name) {


    override fun eat() {
        println(chactor + "学生吃")
    }

    override fun action() {
//        super.action()
        println(name + chactor + "公共场合喜欢大声喧哗")
    }
}