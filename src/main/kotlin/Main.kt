fun main() {
    println("Метод возвращающий одну из изначальных коллекций целиком")
    SummerHouseDAO().getAllOwner().forEach { println(it) }
    println()
    val list = joinСollections()
    println("Объединение двух источников данных")
    list.forEach { println(it) }
    println()
    println("Сортировка по количеству комнат")
    sortingTheNumberOfRooms(list).forEach { println(it) }
    println()
    println("Группировка по названию первый буквы в название улицы ")
    groupingElements(list).forEach { println(it) }
    println()
    println("Фильтрация списка по количеству метров ")
    filterMeters(list, 58).forEach { println(it) }
}
