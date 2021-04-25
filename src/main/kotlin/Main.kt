fun main() {

    val queue = queue("1",2,3)

    queue.enqueue("4")
    println(queue.dequeue())//1
    println(queue.dequeue())//2
    println(queue.dequeue())//3
    println(queue.dequeue())//4
    println(queue.dequeue())//null
    queue.enqueue(5)
    println(queue.dequeue())//5

    println()
    println("=====/////====")
    println()

    val stack = stack(1,2,3)

    println(stack.pop())//3
    stack.push(4)
    println(stack.pop())//4
    println(stack.pop())//2
    println(stack.pop())//1
    println(stack.pop())//null

}

