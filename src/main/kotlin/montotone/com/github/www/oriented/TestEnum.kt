package montotone.com.github.www.oriented

enum class TestEnum {
    IDLE, RUNNING, FINISHED ;                          // 1

    fun getState():String{
        return this.name
    }
}