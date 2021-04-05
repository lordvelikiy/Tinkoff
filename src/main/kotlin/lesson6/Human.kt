package lesson6

data class Human(
    val name: String,
    val age: Int
) {
    fun identicalNames(human: Human) = this.name == human.name

    fun leftToAge(needAge: Int): String {
        if (age >= needAge)
            return "age normal"
        return "need another ${needAge - age} years"
    }
}