package vishnu.function

import com.sun.corba.se.impl.orbutil.graph.Graph
import sun.security.provider.certpath.Vertex

open class A {
    open fun foo(i: Int = 10): Int {
        return i
    }
}

class B : A() {
    override fun foo(i: Int): Int {
        return i
    }

    fun foos(bar: Int = 0, baz: Int) {

    }

    fun test() {
        foos(bar = 3, baz = 3)
    }
}

fun fooLambda(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {
    qux()
}

fun test() {
    fooLambda(1, 2, { System.out.println("hello") })
    fooLambda(1) { System.out.println("kotlin") }
    fooLambda { println("Vishnu") }
}

fun reformatter(
    str: String, normalizeCast: Boolean = true,
    upperCaseFirstLLetter: Boolean = true,
    divideByCamelHumps: Boolean = true,
    workSeperator: Char = ' '
) {
}

fun testReformatter() {
    val str = "Kotlin"
    reformatter(str)
    reformatter(
        str,
        normalizeCast = true,
        upperCaseFirstLLetter = true,
        divideByCamelHumps = false,
        workSeperator = '_'
    )
    reformatter(
        str,
        workSeperator = ','
    )
}

fun fooVarags(vararg strings: String) {}

fun testFooVarargs() {
    fooVarags(strings = *arrayOf("1", "2"))
}

fun printHelloName(name: String): Unit {
    if (name != null) {
        println("Hello $name")
    } else {
        println("Hi there!")
    }
}

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}

fun twoTimes(x: Int): Int = x * 2
fun twoTimess(x: Int) = x * 2

fun mainTest(args: Array<String>) {
    println(A().foo())
    println(B().foo())
    test()
    //
    val list = asList(1, 2, 3)
    val list2 = asList(arrayOf(1, 2, 3))
}

/**     Infix Function      */
infix fun Int.shl2(x: Int): Int {
    return 0
}

fun mainInfix() {
    val result = 1 shl2 2
    1.shl2(2)
}

class MyStrigCollection {
    infix fun add(s: String) {

    }

    fun build() {
        this add "abc"
        add("abc")
        //add "abc" // error
    }
}

/**Function scope*/
fun dfs(graph: Graph) {
    val visited = HashSet<Vertex>()
    fun dfs(current: Graph) {
        if (visited.isEmpty()) return
        for (v in arrayOf(2)) {
            dfs(current)
        }
    }
}

/** Member Function */
class Example {
    fun foo() {
        println("Foo")
    }
}

fun main(args: Array<String>) {
    Example().foo()

    findFixPoint(1.0)
    findFixPoint()
}

/** Tail Recursion */
tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

private fun findFixPoint(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (x == y) return x
        x = y
    }
}

class Foo
class Bar

var foo: Foo
    get() {
       return Foo()
    }
    inline set(value) {}

val bar1: Bar
    inline get() = Bar()

inline var bar2: Bar
    get() = Bar()
    set(value) {

    }
