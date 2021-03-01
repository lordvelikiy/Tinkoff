fun main() {
    val first = Turn()
    first.enqueue("1")
    first.enqueue("2", 3, true)
    for (i in 0..5) {
        print("${first.dequeue()}, ")
    }
println()
    val stack =Stack()
    stack.push(1)
    stack.push("Second",3,4)

    for (i in 0..5) {
        print("${stack.pop()}, ")
    }

}

