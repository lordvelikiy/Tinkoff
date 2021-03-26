package lesson5

class PersonData {

    private val listPerson = listOf(
        Person(1, "Vladislav", 26, 1),
        Person(2, "Ekaterina", 30, 1),
        Person(3, "Elena", 42, 2),
        Person(4, "Sergey", 62, 2),
        Person(5, "Oleg", 41, 3)
    )

    fun getList() = listPerson
}

class ApartmentData {

    private val listApartment = listOf(
        Apartment(1, "Gagarina 18 ", 36.3),
        Apartment(2, "Firsova 43", 72.6),
        Apartment(3, "Lenina 6/4", 54.2)
    )

    fun getList() = listApartment
}

class ComputerLanguageData {

    private val listComputerLanguage = listOf(
        ComputerLanguage(1, "Kotlin"),
        ComputerLanguage(2, "Java"),
        ComputerLanguage(3, "C#"),
        ComputerLanguage(4, "C++"),
        ComputerLanguage(5, "GO")
    )

    fun getList() = listComputerLanguage
}

class PersonComputerLanguageData {

    private val listPersonComputerLanguage = listOf(
        PersonComputerLanguage(1, 1),
        PersonComputerLanguage(1, 2),
        PersonComputerLanguage(2, 5),
        PersonComputerLanguage(3, 2),
        PersonComputerLanguage(3, 4),
        PersonComputerLanguage(4, 3),
        PersonComputerLanguage(5, 2),
        PersonComputerLanguage(5, 3),
        PersonComputerLanguage(5, 4),
        PersonComputerLanguage(5, 5)
    )

    fun getList() = listPersonComputerLanguage
}

