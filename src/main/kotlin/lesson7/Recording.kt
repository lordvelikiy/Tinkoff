package lesson7

import kotlin.concurrent.thread

fun recording() {

    thread {
        repeat(5) {
            while ((Data.common != Data.threadValue1) ||
                (Data.common != Data.threadValue2) ||
                (Data.common != Data.threadValue3)
            ) {
            }
            println("Новое значение = ${++Data.common}")
        }
    }

    thread {
        Data.threadValue1 = 0
        while (true) {
            if (Data.common != Data.threadValue1) {
                Thread.sleep(10)
                println(
                    "${Thread.currentThread().name} заметил изменение с " +
                            "${Data.threadValue1} до ${Data.common}"
                )
                ++Data.threadValue1
                if (Data.common == 5) return@thread
            }
        }
    }

    thread {
        Data.threadValue2 = 0
        while (true) {
            if (Data.common != Data.threadValue2) {
                Thread.sleep(10)
                println(
                    "${Thread.currentThread().name} заметил изменение с " +
                            "${Data.threadValue2} до ${Data.common}"
                )
                ++Data.threadValue2
                if (Data.common == 5) return@thread
            }
        }
    }

    thread {
        Data.threadValue3 = 0
        while (true) {
            if (Data.common != Data.threadValue3) {
                Thread.sleep(10)
                println(
                    "${Thread.currentThread().name} заметил изменение с " +
                            "${Data.threadValue3} до ${Data.common}"
                )
                ++Data.threadValue3
                if (Data.common == 5) return@thread
            }
        }
    }
    Thread.sleep(1000)
}

object Data {

    @Volatile
    var common = 0

    var threadValue1 = -1

    var threadValue2 = -1

    var threadValue3 = -1
}

fun main() {

    recording()


}