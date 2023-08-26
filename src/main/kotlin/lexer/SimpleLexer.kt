package lexer

import Item
import kotlin.math.exp

object SimpleLexer: Lexer {
    fun parse(input: String): List<Item> {
        val inputSplit = input.split(" ")
        val expr = mutableListOf<Item>()
        for (each in inputSplit) {
            when (each) {
                "*" -> {
                    expr.add(Item.mul())
                }
                "-" -> {
                    expr.add(Item.sub())
                }
                "+" -> {
                    expr.add(Item.add())
                }
                "/" -> {
                    expr.add(Item.div())
                }
                else -> {
                    expr.add(Item.value(each.toInt()))
                }
            }
        }
        return expr
    }
}

