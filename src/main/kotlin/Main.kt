fun main(args: Array<String>) {
//    val stack = StaticStack(3)
//
//    stack.push(2)
//    stack.push(3)
//    stack.push(4)
//
//    stack.printStack()
//
//    println(stack.pop())
//    stack.printStack()


    val expr = listOf(Item.value(10), Item.value(2), Item.value(5), Item.mul(), Item.add())

    val calculator = Calculator(expr, StackType.DYNAMIC)
    calculator.run()
}

class Item (var itemType: ItemType) {
    var value: Int = 0
    companion object {
        fun add(): Item {
            return Item(ItemType.ADD)
        }

        fun sub(): Item {
            return Item(ItemType.SUB)
        }

        fun mul(): Item {
            return Item(ItemType.MUL)
        }

        fun div(): Item {
            return Item(ItemType.DIV)
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


