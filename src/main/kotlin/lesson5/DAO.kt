package lesson5

interface DAO {
    fun getList(): List<Any>
    fun getValueString(): String
}

data class Person(val id: Int, val name: String, val age: Int, val idApartment: Int) : DAO {

    override fun getList(): List<Any> = listOf(id, name, age, idApartment)

    override fun getValueString(): String = "$id, \"$name\", $age, $idApartment"
}

data class PersonComputerLanguage(val idPerson: Int, val idComputerLanguage: Int) : DAO {

    override fun getList(): List<Any> = listOf(idPerson, idComputerLanguage)

    override fun getValueString(): String = "$idPerson, $idComputerLanguage"
}

data class ComputerLanguage(val id: Int, val nameLanguage: String) : DAO {

    override fun getList(): List<Any> = listOf(id, nameLanguage)

    override fun getValueString(): String = "$id, \"$nameLanguage\""
}

data class Apartment(val id: Int, val address: String, val squareMeters: Double) : DAO {

    override fun getList(): List<Any> = listOf(id, address, squareMeters)

    override fun getValueString(): String = "$id, \"$address\", $squareMeters"
}
