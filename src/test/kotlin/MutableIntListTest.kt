import org.junit.jupiter.api.Test
import stack.MutableIntList

class MutableIntListTest {

    private var mutableList = MutableIntList(1, 3, 4)
    @Test
    fun add() {
        mutableList.add(5)
        println(mutableList)
    }

    @Test
    fun removeLast() {
    }
}