package lesson6

fun Int.adult() = when (this) {
    in 0..17 -> false
    in 18..130 -> true
    else -> throw AgeException()
}

class AgeException(x: String = "") : Exception("Wrong age \n$x")