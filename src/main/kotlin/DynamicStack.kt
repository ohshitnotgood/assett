class DynamicStack: Stack {
    private val array = mutableListOf<Int>()

    private val r = MutableIntList(1, 3, 4)
    private var stackPointer = 0

    override fun push(value: Int) {
        array.add(value)
    }

    override fun pop(): Int {
        return array.removeLast()
    }

    override fun printStack() {
        println(array.toList())
    }
}

class MutableIntList(vararg elements: Int) {
    private var array = elements

    fun add(value: Int) {
        val tempArray = IntArray(array.size + 1)
        tempArray[array.size] = value
        this.array = tempArray
    }

    fun removeLast() {
        this.array = array.removeLastAndReturnArray()
    }
}

interface Stack {
    fun printStack()
    fun push(value: Int)

    fun pop(): Int
}