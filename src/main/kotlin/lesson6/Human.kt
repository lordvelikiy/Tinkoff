package lesson6

//2)Создать класс с 2 методами, один возвращает булевое значение, другой
// – отличный от булевого тип. Оба методы должны иметь минимум 1 входной параметр,
// в зависимости от которого формируется логика каждого метода.
data class Human(
    val name: String,
    val age: Int
) {
    //одинаковые Имена
    fun identicalNames(human: Human) = this.name == human.name

    //осталось состариться
    fun leftToAge(needAge: Int): String {
        if (age >= needAge)
            return "age normal"
        return "need another ${needAge - age} years"
    }
}

fun main() {
    val a = Human("gogi", 23)
    val b = Human("kola", 13)
    val b1 = Human("Ford", 18)
    val b2 = Human("lotus", 16)
    val b3 = Human("Zara", 44)



    println(a.identicalNames(b))
    //false
    println(a.leftToAge(17))
    //age normal
    println(b.leftToAge(17))
    //need another 4 years
}