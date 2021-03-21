data class SummerHouse(val owner: String, val houseNumber: String, val meters: Int)
class SummerHouseDAO {

    private val list = listOf(
            SummerHouse("Vladislav", "86", 62),
            SummerHouse("Ekaterina", "12", 57),
            SummerHouse("Vladimir", "4b", 87),
            SummerHouse("Elena", "18/a", 74),
            SummerHouse("Julia", "146", 34),//Владелец которого нет в другом списке
            SummerHouse("Sergey", "Test", 38)
    )

    fun getAllOwner() = list

    //Метод, возвращающий элемент коллекции по тому полю, которое объединяет оба класса данных
    fun getOwner(owner: String): Any {
        //Проверка на содержание такого владельца в списке
        list.forEach {
            if (it.owner == owner)
                return it
        }
        return "Owner information not found"
    }
}