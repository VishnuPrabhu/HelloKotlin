package vishnu.collections


fun demoEg() {
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    val readOnlyView: List<Int> = numbers
    println(numbers)
    numbers.add(4)
    println(readOnlyView)
    //readOnlyView.clear()  // throws compile time error

    val strings = hashSetOf<String>("a", "b", "c", "c")
    print("${strings.size == 3}")
}

class Controller {
    private val _item = mutableListOf<String>()
    val items: List<String> get() = _item.toList()
}

fun demoUtilMethods() {
    val items = listOf(1, 2, 3, 4)
    println(items.first() == 1)
    println(items.last() == 4)

    val filtered = items.filter { it % 2 == 0 }

    val rwList = mutableListOf(1, 2, 3)
    println(rwList.requireNoNulls())
    if (rwList.none { it > 6 }) {
        println("No items above 6")
    }
    val item = rwList.firstOrNull()
    //rwList.sort()
    //rwList.zip()
    //rwList.fold()
    //rwList.reduce()

    // Map
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])
    val snapshot: Map<String, Int> = HashMap(readWriteMap)

}