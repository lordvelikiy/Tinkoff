
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class CurrentTime {
    private val possibleWeather = listOf(
        "Sunny",
        "Rain",
        "Snow",
        "Cloudy"
    )//
    //"Солнечно",
    //"Дождь",
    //"Снег",
    //"Облачно"

    //время
    val time: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
    //погодаp
    val weather: String = possibleWeather[time.hashCode() % 4]
    //влажность
    val humidity: Int = time.hashCode() % 100 + 1
}
//время сервис
class TimeService {
    suspend fun getTime(): String {

        val time = CurrentTime()

            // функция задержки корутин принимает время
        delay(Random.nextLong(100, 1000))
        return time.time
        // пример вывода 19:47:37
    }
}
//погода сервис
class WeatherService {
    suspend fun getExtraInfo(): String {

        val time = CurrentTime()

        delay(Random.nextLong(100, 1000))


        return "${time.weather} ${time.humidity}%"
        //пример вывода  Cloudy 32%
    }
}

fun main() {

}