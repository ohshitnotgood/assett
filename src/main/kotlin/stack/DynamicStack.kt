package stack

import removeLastAndReturnArray

class DynamicStack: Stack {
    private var array = IntArray(0)
    override fun push(value: Int) {
        val tempArray = IntArray(array.size + 1)
        for (each in array.indices) tempArray[each] = array[each]
        tempArray[array.size] = value
        this.array = tempArray
    }

    override fun pop(): Int {
        val lastItem = array.last()
        this.array = array.removeLastAndReturnArray()
        return lastItem
    }

    override fun printStack() {
        println(array.toList())
    }
}


