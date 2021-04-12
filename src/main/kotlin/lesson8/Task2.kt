package lesson8

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val scheduleDay = scheduleDay().iterator()

    while (scheduleDay.hasNext()) {
        println(scheduleDay.next())
    }
}

suspend fun CoroutineScope.scheduleDay() = produce {
    var time = 5

    while (true) {
        delay(1000)
        send("$time:00 ${planDay(time)}")
        time++
        if (time > 23) time = 0
    }
}

fun planDay(r: Int) = when (r) {
    7 -> "Подъем"
    8 -> "Завтрак"
    9 -> "Подготовка к работе"
    in 10..13 -> "Работа"
    14 -> "Обед"
    in 15..19 -> "Работа"
    20 -> "Ужин"
    21, 22 -> "просмотр фильма"
    else -> "Сон"
}