package montotone.com.github.www.basic

fun main(){
    testNullSafety()
}
private fun testNullSafety() {
    var neverNull: String = "This can't be null"            // 1

//    neverNull = null                                        // 2

    var nullable: String? = "You can keep a null here"      // 3

    nullable = null

    if (nullable != null && nullable.length > 0) {        // 2
        print("String of length ${nullable.length}")
    } else {
        print("Empty or null string")                      // 3
    }

    println("length=" + nullable?.length)
}
