open class Doctor(name: String, workplace: String) : Worker(name, workplace) {

    override fun work() {
        "$name выличил пациента".prettyPrint()
    }

    fun inspection() {
        println("$name осмотрел пациента")
    }
}