package montotone.com.github.www.basic.testenum

enum class ColorEnum(val r: Int, val g: Double, val b: Char) {
    RED(1, 1.1, '1'), GREEN(1, 1.11, '1');

    fun getRgb(): String {
        return "r="+r.toString() +"b="+ b.toString() + "g="+g.toString()
    }
}

