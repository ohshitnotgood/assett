import lexer.SimpleLexer

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


//    val expr = listOf(Item.value(3), Item.value(4), Item.mul(), Item.value(5), Item.value(6), Item.mul(), Item.add())

    val expr = SimpleLexer.parse("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 + * + * + * + * + * + * + * +")
    val calculator = Calculator(expr, StackType.STATIC)
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


