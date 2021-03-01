package Test

fun main() {
    var voloda = User("alwks","grachev")
    var vid = User(secondName = "Bob")
    println(vid.secondName)
    vid.login="Codi"
    println(vid.login)
}