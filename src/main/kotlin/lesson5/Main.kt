package lesson5

fun interval() {
    println("------/////------")
}

fun main() {
    val person = Table(
        "Person",
        personArgs,
        personArgsMap,
        PersonData().getList()
    )
    val computerLanguage = Table(
        "ComputerLanguage",
        computerLanguageArgs,
        computerLanguageArgsMap,
        ComputerLanguageData().getList()
    )
    val apartment = Table(
        "Apartment",
        apartmentArgs,
        apartmentArgsMap,
        ApartmentData().getList()
    )
    val personComputerLanguage = Table(
        "PersonComputerLanguage",
        personComputerLanguageArgs,
        personComputerLanguageArgsMap,
        PersonComputerLanguageData().getList()
    )

    val init = InitClass(listOf(person, computerLanguage, apartment, personComputerLanguage))

    init.createAllTables()
    interval()
    init.insertValuesInTables()
    interval()

    val serviceClass = ServiceClass()

    println("Значение в таблице person найденное по id равным 2")
    serviceClass.getBy(person, "id", 2, "=").forEach { println(it) }

    interval()

    println("Значения в таблице apartment где squareMeters больше 38")
    serviceClass.getBy(apartment, "squareMeters", 38, ">").forEach { println(it) }

    interval()

    println("Выборка данных из связанных таблиц где связь один к многим")
    serviceClass.selectionFromTables(person, apartment).forEach { println(it) }

    interval()

    println("Выборка с группировкой по полю nameLanguage из таблиц где связь многие ко многим")
    serviceClass.selectionWithGrouping(person, computerLanguage, personComputerLanguage).forEach { println(it) }

    interval()

    println("Выборка и сортировка в таблице Person в порядке убывания значений")
    serviceClass.selectAndSort(person).forEach { println(it) }

    interval()

    init.deleteAllTables()
}

