import kotlin.math.exp
import kotlin.properties.Delegates

fun main(args: Array<String>) {
    val expr = mutableListOf(Item.value(20), Item.value(10), Item.value(30))

    val rc = mutableListOf(1, 2, 3)
    println("list element " + rc[1])

    val r = Calculator(expr)
    r.run()
    r.stack.printStack()
}

class Calculator( private val expr: MutableList<Item> ) {

    private var ip: Int = 0
    val stack = Stack(expr.size)


    fun run() {
        while (ip < expr.size) {
            step()
        }
    }

    private fun step() {
        val nxt = expr[0]
        ip += 1

        when (nxt.type) {
            ItemType.ADD -> {
                val y = stack.pop()
                val x = stack.pop()
                stack.push(y + x)
            }
            ItemType.SUB -> {}
            ItemType.MUL -> {}
            ItemType.DIV -> {}
            ItemType.VALUE -> {
                stack.push(nxt.value)
            }
        }
    }
}


class Item {

    companion object {

        lateinit var type: ItemType
        var value = 0

        fun add(): Item {
            this.type = ItemType.ADD
            return this
        }

        fun sub(): Item {
            this.type = ItemType.SUB
            return this
        }

        fun mul(): Item {
            this.type = ItemType.MUL
            return this
        }

        fun div(): Item {
            this.type = ItemType.DIV
            return this

        }

        fun value(value: Int): Item {
            this.type = ItemType.VALUE
            this.value = value
            return Item()
        }
    }
}

class Stack(private val stackSize: Int?) {
    // Stack pointer starts at -1 because Kotlin arrays start at index 0 hence first push moves stack pointer to 0
    private var stackPointer = -1
    private val array = mutableListOf<Int>()

    /**
     * Retrieves element from stack at stack pointer position
     */
    fun pop(): Int {
        return array[stackPointer--]
    }

    fun push(element: Int) {
        array.add(element)
        stackPointer++
        println(stackPointer)
    }

    fun printStack() {
        println(array.toString())
    }
}

enum class StackType {
    STATIC, DYNAMIC
}

enum class ItemType {
    ADD, SUB, MUL, DIV, VALUE
}

class SimpleLexer {
    fun getInput() {

    }
}