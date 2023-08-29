package stack

import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.random.Random

class StaticStackTest {

    private val stackSize = 1024
    private val stack = StaticStack(stackSize)
    @Test
    fun benchmark() {
        val startTime = Date().time
        autoPush()
        autoPop()
        val endTime = Date().time
        println("Time taken: " + (endTime - startTime) + "ms")

        while (true) {

        }
    }

    private fun autoPush() {
        for (each in 0..< stackSize) {
            stack.push(Random.nextInt(0, 1000))
        }
    }

    private fun autoPop() {
        for (each in 0..< stackSize) {
            stack.pop()
        }
    }
}