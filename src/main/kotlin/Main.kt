fun main() {
    val vasily = Doctor("Василий", "Больница свтого Петра")
    val viktor = HeadPhysician("Виктор Валентинович", "клиническая больница имени  \"Семашко\"")
    val vazgen = Seller("Вазген", "центральный рынок")
    val vladimir = Cook("Владимир", "закусочная №5")
    val alexander = Cook("Александр", "закусочная №6")
    val evgeniy = Chef("Евгений Олегович", "ресторан \"Сахалин\"")


    val worker = listOf(vasily, viktor, vazgen, vladimir, evgeniy, alexander)
    worker.forEach {
        it.work()
    }
    val cook = listOf(vladimir, evgeniy)
    cook.forEach {
        it.cutting()
    }
    println()
    val doctor = listOf(vasily, viktor)
    doctor.forEach {
        it.inspection()
    }
    println()

    viktor.teaches(vasily)
    viktor.teaches(vasily)
    evgeniy.teaches(vasily)
    evgeniy.teaches(vladimir)
    evgeniy.teaches(alexander)
    println()

    val mentor = listOf<Mentor>(evgeniy, viktor)
    mentor.forEach() {
        it.numberOfStudents()
        it.numberOfStudents(vladimir)
    }
    println()
    with(vazgen) {
        sell()
        sell()
        think()
        sell()
        think()
    }
}