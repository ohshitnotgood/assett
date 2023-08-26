fun main(args: Array<String>) {
    val stack = StaticStack(3)

    stack.push(2)
    stack.push(3)
    stack.push(4)

    stack.printStack()

    println(stack.pop())
    stack.printStack()


    val expr = listOf(Item.value(1), Item.value(3), Item.add())

    val calculator = Calculator(expr)
    calculator.run()
}

class Calculator (private val expr: List<Item>){

    private val stack = StaticStack(expr.size)
    private var instructionPointer = 0


    fun run() {
        while (instructionPointer < expr.size) {
            if (expr[instructionPointer].itemType == ItemType.VALUE) {
                stack.push(expr[instructionPointer].value)
                println("adding value")
            } else {
                stack.push(null)
            }
            instructionPointer++
        }

        stack.printStack()
    }
}


class Item (var itemType: ItemType) {
    var value: Int = 0
    companion object {
        fun add(): Item {
            val item = Item(ItemType.ADD)
            return item
        }

        fun value(value: Int): Item {
            val item = Item(ItemType.VALUE)
            item.value = value
            return item
        }
    }
}

enum class ItemType {
    ADD, SUB, MUL, DIV, VALUE
}

class StaticStack(private var size: Int) {
    private var array = Array<Int?>(size) {it}
    private var stackPointer = -1

    fun push(value: Int?) {
        stackPointer++
        array[stackPointer] = value
    }

    fun pop(): Int? {
        val r = array[stackPointer--]
        this.array = array.removeLast()
        return r
    }

    fun printStack() {
        println(array.toList())
    }
}


inline fun <reified T> Array<T>.removeLast(): Array<T> {
    val tempArray = Array(this.size - 1) {
        it as T
    }

    for (each in 0..this.size - 2) {
        tempArray[each] = this[each]
    }
    return tempArray
}


class DynamicStack {
    private val array = mutableListOf<Int>()
    private var stackPointer = 0

    fun push(value: Int) {
        array.add(value)
    }

    fun pop(): Int {
        return array.removeLast()
    }

    fun printStack() {

    }
}