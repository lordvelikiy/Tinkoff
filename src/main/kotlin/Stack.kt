class Stack {
    private var stack = mutableListOf<Any>()

    fun push(vararg value: Any) {
        value.forEach { el -> stack.add(el) }
    }

    fun pop(): Any {
        if (stack.size == 0) return "Stack is empty"
        val value = stack.last()
        stack.removeAt(stack.size - 1)
        return value
    }

}