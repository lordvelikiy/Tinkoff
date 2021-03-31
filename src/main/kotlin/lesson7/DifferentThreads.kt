package lesson7

import java.util.concurrent.Executors
import kotlin.concurrent.thread

fun differentThreads() {

    Thread(Runnable {
        Thread.currentThread().priority = 3
        Thread.currentThread().name = "Runnable"
        println(
            "name - ${Thread.currentThread().name}, priority = " +
                    "${Thread.currentThread().priority}"
        )
    }).apply { start() }

    thread {
        Thread.currentThread().priority = 8
        Thread.currentThread().name = "Thread"
        println(
            "name - ${Thread.currentThread().name},  priority = " +
                    "${Thread.currentThread().priority}"
        )
    }

    Executors.newFixedThreadPool(2).apply {
        repeat(2) {
            submit {
                println(
                    "name - ${Thread.currentThread().name}, priority = " +
                            "${Thread.currentThread().priority}"
                )
            }
        }
        shutdown()
    }

    thread(name = "Daemon", isDaemon = true) {
        println(
            "name - ${Thread.currentThread().name}, " +
                    "isDaemon = ${Thread.currentThread().isDaemon}"
        )
    }

    myThread("myThread dsl")

    Thread.sleep(1000)
}

fun myThread(
    name: String
): Thread {
    val myThread = object : Thread() {
        override fun run() {
            currentThread().name = name
            println("name - ${currentThread().name}")
        }
    }
    myThread.start()
    return myThread
}
