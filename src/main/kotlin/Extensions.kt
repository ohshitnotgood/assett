
inline fun <reified T> Array<T>.removeLast(): Array<T> {
    val tempArray = Array(this.size - 1) {
        it as T
    }

    for (each in 0..this.size - 2) {
        tempArray[each] = this[each]
    }
    return tempArray
}

fun IntArray.removeLastAndReturnArray(): IntArray {
    val tempArray = IntArray(this.size - 1)

    for (each in 0..this.size - 2) {
        tempArray[each] = this[each]
    }
    return tempArray
}
