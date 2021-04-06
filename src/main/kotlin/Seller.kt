class Seller(name: String, workplace: String) : Worker(name, workplace) {
    private var tomatoes: Int = 160
        set(value) {
            field = value
            println("$name продал 10 помидор")
        }

    override fun work() {
        "$name пересчитывает продукты".prettyPrint()

    }

    fun think() {
        println("$name думает как продать еще $tomatoes штук помидор")

    }

    fun sell() {
        tomatoes -= 10
    }
}