package montotone.com.github.www.test_delegation

fun main() {
    val tomAraya = TomAraya("Thrash Metal")
    tomAraya.makeSound()                                                           // 4
    val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
    elvisPresley.makeSound()
}

interface SoundBehavior {                                                          // 1
    fun makeSound()
}

class ScreamBehavior(val n: String) : SoundBehavior {
    override fun makeSound() {
        println("${n.toUpperCase()} !!!")
    }
}

class RockAndRollBehavior(val n: String) : SoundBehavior {                           // 2
    override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")
}

// Tom Araya is the "singer" of Slayer
class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)

// You should know ;)
//class ElvisPresley(n: String) : SoundBehavior             // 3
class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)              // 3
