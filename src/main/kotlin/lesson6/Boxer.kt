package lesson6

data class Boxer(
    var id: Int = 0,
    var speed: Int = 0,
    var weight: Int = 0
) {
    fun willWin(opponent: Boxer) =
        (speed * weight) > (opponent.speed * opponent.weight)
}

fun boxer(block: Boxer.() -> Unit): Boxer =
    Boxer().apply(block)

fun main() {
    val boxer = Boxer(3, 16, 42)
    val boxer2 = Boxer(1, 15, 21)
    println(boxer.willWin(boxer2))
    println(boxer2.willWin(boxer))
}