class HeadPhysician(override val name: String, override val workplace: String,private var students :Int=0) :Doctor(name, workplace),Study {

    override fun teaches() {
        println("${name} обучил двух врачей")
        students+=2
    }

    override fun numberOfStudents() {
        println("${students} - количество врачей которыч обучил ${name}")
    }
}