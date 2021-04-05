package lesson6


//4)Создать класс для тестирования DSL c не менее чем 2 полями и 1 методом
// с входными/выходными параметрами. Для класса создать одноименную функцию,
// которая будет принимать в качестве параметра лямбду вида
// block: ClassName.() -> Unit и будет возвращать новый экземпляр класса,
// с примененной к нему лямбдой. Написать тест с использованием mock’a,
// настроить mock, чтобы для каждого свойства и метода возвращалось определённое значение.

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
    val boxer = Boxer(3,16,42)
    val boxer2 = Boxer(1,15,21)
      println(boxer.willWin(boxer2))
      println(boxer2.willWin(boxer))
}