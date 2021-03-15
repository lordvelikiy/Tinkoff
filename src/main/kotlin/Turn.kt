class Queue<T> {

    private var turn = mutableListOf<T>()

    fun enqueue(vararg value: T) {
        value.forEach { el -> turn.add(el) }
    }

    fun dequeue(): T {
        val value = turn[0]
        turn.removeAt(0)
        return value
    }
}
