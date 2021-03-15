class Stack<T> {
    private var stack = mutableListOf<T>()

    fun push(vararg value: T) {
        value.forEach { el -> stack.add(el) }
    }

    fun pop(): T {
        val value = stack.last()
        stack.removeAt(stack.size - 1)
        return value
    }
}
fun <T> StackList(vararg elements: T): Stack<T> {
    var test = Stack<T>()
    elements.forEach { test.push(it) }
    return test
}
