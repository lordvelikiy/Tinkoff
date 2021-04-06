import java.time.LocalDateTime
import java.time.format.DateTimeFormatter




import kotlinx.coroutines.*

fun main() {
    var time = ""
    var weath = ""
    runBlocking {
        launch {
            time = getTime()
        }
        launch {
            weath = getWeather()
        }
    }
    println(time.concat(weath))
}

fun String.concat(str: String) =
    "$this\n$str"

suspend fun getTime(): String {
    // класс с вединственным методом вернуть время
    return TimeService().getTime()
}

suspend fun getWeather(): String {
    // класс с единственным методом вернуть  Cloudy 32%
    return WeatherService().getExtraInfo()
}