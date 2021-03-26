package lesson5

import java.lang.Exception

class Table(
    val tableName: String,
    val args: List<String>,
    val argsMap: Map<String, SQLTypes>,
    val valuesList: List<DAO>
)

fun toColumnString(agr: List<String>): String {
    var str = ""
    for (i in agr.indices) {
        str += when (i) {
            agr.size - 1 -> {agr[i]}
            else -> "${agr[i]}, "
        }
    }
    return str
}

enum class SQLTypes {
    TEXT, INT, REAL
}

val apartmentArgs = listOf("id", "address", "squareMeters")
val computerLanguageArgs = listOf("id", "nameLanguage")
val personComputerLanguageArgs = listOf("idPerson", "idComputerLanguage")
val personArgs = listOf("id", "name", "age", "idApartment")
val personAndApartmentArgs = listOf("name", "age", "address", "squareMeters")
val personAndComputerLanguageArgs = listOf("name", "age", "nameLanguage")

fun findTheRightMap(vararg table: Table) =
    when (table.size) {
        3 -> personAndComputerLanguageArgsMap
        2 -> personAndApartmentArgsMap
        else -> when (table[0].tableName) {
            "Person" -> personArgsMap
            "Apartment" -> apartmentArgsMap
            "ComputerLanguage" -> computerLanguageArgsMap
            else -> throw Exception()
        }
    }

val apartmentArgsMap = mapOf(
    "id" to SQLTypes.INT,
    "address" to SQLTypes.TEXT,
    "squareMeters" to SQLTypes.REAL
)
val computerLanguageArgsMap = mapOf(
    "id" to SQLTypes.INT,
    "nameLanguage" to SQLTypes.TEXT
)

val personArgsMap = mapOf(
    "id" to SQLTypes.INT,
    "name" to SQLTypes.TEXT,
    "age" to SQLTypes.INT,
    "idApartment" to SQLTypes.INT
)
val personAndApartmentArgsMap = mapOf(
    "name" to SQLTypes.TEXT,
    "age" to SQLTypes.INT,
    "address" to SQLTypes.TEXT,
    "squareMeters" to SQLTypes.REAL
)
val personComputerLanguageArgsMap = mapOf(
    "idPerson" to SQLTypes.INT,
    "idComputerLanguage" to SQLTypes.INT
)
val personAndComputerLanguageArgsMap = mapOf(
    "name" to SQLTypes.TEXT,
    "age" to SQLTypes.INT,
    "nameLanguage" to SQLTypes.TEXT
)
