data class Apartment(val owner: String, val street: String, val rooms: Int)
class ApartmentDAO {

    private val list = listOf<Apartment>(
            Apartment("Vladislav", "Gagarina", 4),
            Apartment("Ekaterina", "Firsova", 3),
            Apartment("Vladimir", "Lenina", 7),
            Apartment("Elena", "Frunze", 6),
            Apartment("Tom", "Velikanova", 3),//Владелец которого нет в другом списке
            Apartment("Sergey", "Firsova", 3)
    )

    fun getAllOwner() = list
}