open class Doctor (override val name: String, override val workplace: String ) :Worker {

    override fun work() {
    "${name} выличил пациента".prettyPrint()

    }
    fun inspection (){
        println("${name} осмотрел пациента")
    }
}