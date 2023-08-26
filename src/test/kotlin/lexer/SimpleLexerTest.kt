package lexer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SimpleLexerTest {
    @Test fun parse() {
        val parseResult = SimpleLexer.parse("3 4 * 5 6 * +")
    }
}