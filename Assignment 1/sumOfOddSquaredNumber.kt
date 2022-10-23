
fun sumOfOddSquared(values: Array<Int>): Int {
    val oddValues = values.filter { it % 2 != 0  }
    return oddValues.map { it * it }.sum()
}