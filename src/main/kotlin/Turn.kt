class Turn {

    private var turn = mutableListOf<Any>()
    fun enqueue(vararg value: Any) {
        value.forEach { el -> turn.add(el) }

    }

    fun dequeue(): Any {
        if (turn.size == 0) return "Turn is empty"
        val value = turn[0]
        turn.removeAt(0)

        return value
    }
}