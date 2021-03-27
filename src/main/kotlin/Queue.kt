class Queue<T> {

    private var turn = mutableListOf<T>()

    fun enqueue(value: T) {
        turn.add(value)
    }

    fun dequeue(): T? {
        if (turn.isEmpty()) return null
        val value = turn[0]
        turn.removeAt(0)
        return value
    }
}

fun <T> queue(vararg el: T) =
    if (el.isNotEmpty()) {
        val a = Queue<T>()
        for (i in el.indices)
            a.enqueue(el[i])
        a
    } else Queue<T>()
