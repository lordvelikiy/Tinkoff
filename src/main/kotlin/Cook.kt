open class Cook(name: String, workplace: String) : Worker(name, workplace) {

    override fun work() {
        "$name приготовил еду ".prettyPrint()
    }

    open fun cutting() {
        println("$name режит мясо")
    }
}