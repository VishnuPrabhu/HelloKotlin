class Box<T>(t: T) {
    var value = t
}

interface Source<out T> {
    fun next(): T
}

//fun demo(strs: Source<String>) {
//    val objects: Source<Any> = strs
//}

interface Comparable<in T> {
    operator fun compareTo(other: T) : Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(2.0)
    val y:Comparable<Double> = x
}
class Demo {

    fun <R> singletonList(item: R): List<R> {
        return ArrayList<R>()
    }

    fun <T> T.basicToString(): String {
        return toString()
    }

    fun main() {
        val list = singletonList<Int>(1)
        val list2 = singletonList(1)
    }

}

fun <T : kotlin.Comparable<T>> sort(list: List<T>) {
    //
}

fun <T> copyWhenGreater(list: List<T>, threshold: T) : List<String>
    where T : kotlin.CharSequence,
          T : kotlin.Comparable<T> {

    return list.filter { it > threshold }.map { it.toString() }
}


fun main(args: Array<String>) {
    //var box: Box<Int> = Box<Int>(1)
    var box = Box(5)
    println(box)

    //sort(listOf<String>(""))

}