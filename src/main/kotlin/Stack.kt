class Stack<T> {
    private var stack = mutableListOf<T>()

    fun push(value: T) {
        stack.add(value)
    }

    fun pop(): T? {
        if (stack.isEmpty()) return null
        val value = stack.last()
        stack.removeAt(stack.size - 1)
        return value
    }
}

fun <T> stack(vararg el: T) =
    if (el.isEmpty()) Stack<T>()
    else {
        val a = Stack<T>()
        for (i in el.indices)
            a.push(el[i])
        a
    }
