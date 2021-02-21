open class Cook(override val name: String, override val workplace: String) :Worker{
    override fun work() {
      "${name} приготовил еду ".prettyPrint()
    }
    fun cutting(){
        println("${name} режит мясо")
    }
}