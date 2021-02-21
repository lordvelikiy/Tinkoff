fun main() {
    val vasily = Doctor("Василий", "Больница свтого Петра")
    val viktor = HeadPhysician("Виктор Валентинович", "клиническая больница имени  \"Семашко\"")
    val vazgen = Seller("Вазген", "центральный рынок")
    val vladimir = Cook("Владимир", "закусочная №5")
    val evgeniy = Chef("Евгений Олегович", "ресторан \"Сахалин\"")


    val worker = listOf(vasily, viktor, vazgen, vladimir, evgeniy)
    worker.forEach {
        it.work()
    }
    val cook = listOf(vladimir, evgeniy)
    cook.forEach {
        it.cutting()
    }
    val doctor = listOf(vasily, viktor)
    doctor.forEach {
        it.inspection()
    }
    viktor.teaches()
    evgeniy.teaches()
    viktor.numberOfStudents()
    evgeniy.numberOfStudents()
    val study = listOf<Study>(viktor,evgeniy)
    study.forEach{
        it.teaches()
        it.teaches()
        it.numberOfStudents()}

with(vazgen){
    work()
    work()
    think()
    work()
    think()
}
}