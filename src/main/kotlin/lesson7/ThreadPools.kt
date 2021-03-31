package lesson7

import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

fun threadPools() {

    val map = mutableMapOf<Long, Int>()
    for (i in 10..30 step 10) map[pull(i)] = i
    sort(map)
}

fun pull(size: Int): Long {

    val i = AtomicInteger()
    Executors.newFixedThreadPool(size).apply {
        var time = System.nanoTime()
        repeat(size) {
            submit {
                while (i.get() < 1_000_000) i.incrementAndGet()
            }
        }
        time = System.nanoTime() - time
        Thread.sleep(1000)
        shutdown()
        return time
    }
}

fun sort(map: Map<Long, Int>) {

    val list = mutableListOf<Long>()
    map.forEach { list.add(it.key) }
    list.sort()
    list.forEach { println("${map[it]} потоков справились за $it") }
}