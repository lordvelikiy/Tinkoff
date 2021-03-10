//Метод объединяющий два источника данных
fun joinСollections(): List<ApartmentWithSummerHouse> {
    val list = mutableListOf<ApartmentWithSummerHouse>()
    ApartmentDAO().getAllOwner().forEach {
        val objectSummerHouse = SummerHouseDAO().getOwner(it.owner)
        //Проверка принадлежности objectSummerHouse к классу SummerHouse
        if (objectSummerHouse is SummerHouse) {
            list.add(ApartmentWithSummerHouse(it.owner, it.street, it.rooms, objectSummerHouse.houseNumber, objectSummerHouse.meters))
        }
    }
    return list
}

//Метод сортирующий источник даннх по кличеству комнат в порядке возрастания
fun sortingTheNumberOfRooms(list: List<ApartmentWithSummerHouse>): List<ApartmentWithSummerHouse> {
    //Создание listRooms для хранения и сортировке количества комнат из list
    var listRooms = mutableListOf<Int>()
    //Создание list Final записи и возвращения отсортированных объектов по количеству комнат
    var listFinal = mutableListOf<ApartmentWithSummerHouse>()

    list.forEach {
        listRooms.add(it.rooms)
    }

    listRooms.sort()

    for (i in 0 until listRooms.size) {
        list.forEach {
            if (listRooms[i] == it.rooms) {
                //Проверка на отсутствие этого объекта в листе
                if (!listFinal.contains(it))
                    listFinal.add(it)
            }
        }
    }
    return listFinal
}

//Метод группирующий источник даннх по названию первый буквы в название улицы
fun groupingElements(list: List<ApartmentWithSummerHouse>) = list.groupBy { it.street.first().toUpperCase() }

//Метод фильтрующий источник данных по количеству метров
fun filterMeters(list: List<ApartmentWithSummerHouse>, meter: Int) = list.filter { it.meters >= meter }



