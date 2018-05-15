package vishnu.functions

import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun <T> lock(lock: Lock, body: () -> T): T {
    println("body")
    lock.lock()
    try {
        println("body")
        return body()
    } finally {
        println("unlock")
        lock.unlock()
    }
}

class DummyLock : Lock {
    override fun lock() {
    }

    override fun tryLock(): Boolean {
        return false
    }

    override fun tryLock(time: Long, unit: TimeUnit?): Boolean {
        return false
    }

    override fun unlock() {
    }

    override fun lockInterruptibly() {
    }

    override fun newCondition(): Condition {
        val objects = object : Condition {
            override fun signal() {
            }

            override fun await() {
            }

            override fun await(time: Long, unit: TimeUnit?): Boolean {
                return false
            }

            override fun signalAll() {
            }

            override fun awaitNanos(nanosTimeout: Long): Long {
                return 0L
            }

            override fun awaitUninterruptibly() {
            }

            override fun awaitUntil(deadline: Date?): Boolean {
                return false
            }
        }
        return objects
    }
}

val sumNullable: ((Int, Int) -> Int)? = null

fun <T, R> List<T>.map(transform: (T) -> R): List<R> {
    var result = ArrayList<R>()
    for (t in this) {
        result.add(transform(t))
    }
    return result
}

/** Annonymous Function */
val annonymousFun = fun(x: Int, y: Int): Int = x + y
val annonymousFun2 = fun(x: Int, y: Int) {
    x + y
}
val ints = intArrayOf().filter(fun(item) = item > 0)

fun testClosureVar() {
    var sum = 0
    ints.filter { it > 0 }.forEach {
        sum += it
    }
    println(sum)
}

fun mainTest(args: Array<String>) {

    lock(lock = DummyLock()) { 5 }

    //
    val doubled = intArrayOf(1, 2).map { value -> value * 2 }
    var thrice = intArrayOf(1, 3).map { it * 3 }

    // linq styled code
    val stringArray = arrayOf("1", "2", "3")
    val operated = stringArray.filter { it > "0" }.sortedBy { it }.map { it.toUpperCase() }.toList()
    val map = mapOf<String, String>(
        "firstname" to "Vishnu",
        "lastname" to "ramachandran"
    )
    map.forEach { _, value -> println(value) }
}

val sumLiteral: Int.(otherInt: Int) -> Int = { 6 }
val sumLiternalAnnonymous = fun Int.(other: Int): Int = this + other
fun mainSumLiteral() {
    1.sumLiteral(2)
    sumLiteral(1, 2)
}

fun main(args: Array<String>) {
    val represents: String.(Int) -> Boolean = { toIntOrNull() == it }
    println("123".represents(123))

    fun testOperation(op: (String, Int) -> Boolean, a: String, b: Int, c: Boolean) = assert(op(a, b) == c)
    testOperation(represents, "100", 100, true)
}

class Html {
    fun body() {}
}

fun html(init: Html.() -> Unit): Html {
    val html = Html()
    html.init()
    return html
}

fun mainHtmlTest() {
    html {
        body()
    }

    html({
        body()
    })

    val htmlBody: Html.() -> Unit = { body() }
    html(htmlBody)
}


