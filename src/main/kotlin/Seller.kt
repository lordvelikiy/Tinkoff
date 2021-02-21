class Seller (override val name: String, override val workplace: String,private var tomatoes : Int =160) :Worker{
    override fun work() {
        println("${name} продал 10 помидор ")
        tomatoes -=10
    }
fun think(){
    println("${name} думает как продать еще ${tomatoes} штук помидор")

}
}