class HeadPhysician(name: String, workplace: String) : Doctor(name, workplace), Mentor {
    private var list: ArrayList<Worker> = arrayListOf()

    override fun teaches(worker: Worker) {

        if (worker is Doctor) {// проверка являеться ли обучаемый поваром
            if (!list.contains(worker)) {//проверка обучался воркер у него
                list.add(worker)// проверка являеться ли обучаемый и ментор одним человеком
                if (worker == this) println("Самого себя обучить невозможно")
                else println("$name обучил еще одного врача")
            } else println("${worker.name} уже обучался у этого главврача ")
        } else println("$name обучает только врачей ")
    }

    override fun numberOfStudents() {
        println("${list.size} - количество врачей которыч обучил $name")
    }

    override fun numberOfStudents(worker: Worker) {
        if (list.contains(worker)) println("${worker.name} обучался у этого главврача")
        else println("${worker.name} не обучался у этого главврача")
    }
}