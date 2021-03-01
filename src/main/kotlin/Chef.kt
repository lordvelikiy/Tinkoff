class Chef(name: String, workplace: String) : Mentor, Cook(name, workplace) {
    private var list: ArrayList<Worker> = arrayListOf()
    override fun cutting() {
        println("$name разработал новое меню")
    }

    override fun teaches(worker: Worker) {

        if (worker is Cook) {
            if (!list.contains(worker)) {
                list.add(worker)
                if (worker == this) println("Самого себя обучить невозможно")
                else println("$name обучил еще одного повара")
            } else println("${worker.name} уже обучался у этого шеф-повара ")
        } else println("$name обучает только поваров ")
    }

    override fun numberOfStudents() {
        println("${list.size} - количество поваров которых обучил $name")
    }

    override fun numberOfStudents(worker: Worker) {
        if (list.contains(worker)) println("${worker.name} обучался у этого шеф-повара ")
        else println("${worker.name}name не обучался у этого шеф-повара ")
    }

}