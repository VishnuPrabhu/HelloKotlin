package vishnu.exceptiondemo

fun testThrow() {
    throw IllegalArgumentException("Hi, There!")
}

fun catchException() {
    try {
        testThrow()
    } catch (e: Exception) {

    } finally {

    }
}

fun demo() {
    val string: String = "5"
    val a: Int? = try { string.toInt() } catch (e: NumberFormatException) { null }
}

class Person(val name: String) {
    val children: ArrayList<Person> = ArrayList<Person>()

    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}
fun nothingType() {
    val person = Person("Hello")
    val name = person?.name ?: fail()
    println(name)

    val x = null
    val listOfNULL = listOf(null)
}

fun fail() : Nothing {
    throw IllegalArgumentException("Message")
}