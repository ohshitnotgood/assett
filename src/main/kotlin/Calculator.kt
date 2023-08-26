
class Calculator (private val expr: List<Item>, stackType: StackType?){

    private var stack: Stack
    private var instructionPointer = 0


    init {
        stack = if (stackType == StackType.STATIC) {
            StaticStack(expr.size)
        } else {
            DynamicStack()
        }
    }

    fun run() {
        while (instructionPointer < expr.size) {
//            if (expr[instructionPointer].itemType == ItemType.VALUE) {
//                stack.push(expr[instructionPointer].value)
//                println("adding value")
//            } else {
//                stack.push(null)
//            }
//            instructionPointer++
            step()
        }

        stack.printStack()
    }

    private fun step() {
        val x: Int
        val y: Int
        val nextItem = expr[instructionPointer++]

        when (nextItem.itemType) {
            ItemType.ADD -> {
                x = stack.pop()
                y = stack.pop()

                stack.push(x + y)
            }
            ItemType.SUB -> {
                x = stack.pop()
                y = stack.pop()

                stack.push(x - y)
            }
            ItemType.MUL -> {
                x = stack.pop()
                y = stack.pop()

                stack.push(x * y)
            }
            ItemType.DIV -> {
                x = stack.pop()
                y = stack.pop()

                stack.push(x / y)
            }
            ItemType.VALUE -> {
                stack.push(nextItem.value)
            }
        }
    }
}

enum class StackType {
    STATIC, DYNAMIC
}