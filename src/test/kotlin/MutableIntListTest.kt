import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class MutableIntListTest {

    var mutableList = MutableIntList(1, 3, 4)
    @Test
    fun add() {
        mutableList.add(5)
        println(mutableList)
    }

    @Test
    fun removeLast() {
    }
}