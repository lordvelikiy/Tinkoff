package lesson8

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    var a = ""
    var b = ""
    runBlocking {

        launch {

            a = searchTaxi()
        }
        launch {

            b = carTrafficJam()
        }

    }
    println("$a .$b")
}

suspend fun searchTaxi(): String {
    delay(Random.nextLong(1000))
    return if (Random.nextBoolean()) "Такси найдено ,ожидайте"
    else {
        "Такси еще не найдено"
    }
}

suspend fun carTrafficJam(): String {
    delay(Random.nextLong(1000))
    return "Уровень пробок в городе - ${Random.nextInt(11)} баллов"
}