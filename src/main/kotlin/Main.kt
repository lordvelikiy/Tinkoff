fun main() {
    val first = Queue<Any>()
    first.enqueue("1")
    first.enqueue("2", 3, true)
    for (i in 0..2) {
        print("${first.dequeue()}, ")
    }
    println()

    val stack = Stack<Int>()
    stack.push(1)
    stack.push(23, 3, 4)

    for (i in 0..3) {
        print("${stack.pop()}, ")
    }
    println()

    val stackList = StackList("hi", 1, "house")
    for (i in 0..3) {
        print("${stackList.pop()}, ")
    }
}

