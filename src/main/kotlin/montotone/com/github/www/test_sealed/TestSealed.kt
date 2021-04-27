package montotone.com.github.www.test_sealed

sealed  class TestSealed constructor(val name:String){

}

class Cat(val catName:String):TestSealed(catName){

}