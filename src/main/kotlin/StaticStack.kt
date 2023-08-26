class StaticStack(size: Int): Stack {
    private var array = IntArray(size)
    private var stackPointer = -1

    override fun push(value: Int) {
        stackPointer++
        array[stackPointer] = value
    }

    override fun pop(): Int {
        val r = array[stackPointer--]
        this.array = array.removeLastAndReturnArray()
        return r
    }

    override fun printStack() {
        println(array.toList())
    }
}

