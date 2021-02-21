class Chef(override val name: String, override val workplace: String,private var students :Int=0):Cook(name, workplace),Study {
    override fun teaches() {
        println("${name} обучил одного повара")
        ++students
    }

    override fun numberOfStudents() {
        println("${students} - количество поваров которых обучил ${name}")
    }

}