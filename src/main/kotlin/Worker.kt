abstract class Worker(val name: String, val workplace: String) {

    abstract fun work()

    fun String.prettyPrint() {
        println("Имя работника - $name,  место работы - $workplace")
        println(this)
        println()
    }
}