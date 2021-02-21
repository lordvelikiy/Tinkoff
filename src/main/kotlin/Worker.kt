interface Worker {
    val name :String
    val workplace : String
   fun work()

    fun workerInfo()="Информация о работнике".prettyPrint()

    fun String.prettyPrint(){
        println("Имя работника - ${name}  место работы ${workplace}")
        println(this)
        println()
    }
}
