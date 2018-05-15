fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun main(args: Array<String>) {
    var list = mutableListOf<Int>(1, 2, 3, 4)
    list.swap(0,1)
    println(list)

    ExtensionsProp.foo()
    ExtensionsProp.bar()
}

class ExtensionsProp {

    val List<String>.lastValue
        get() = ""

    companion object {

        fun bar() {

        }
    }
}

fun ExtensionsProp.Companion.foo() {

}

class D {
    fun bar() {

    }
}

class C {
    fun baz() {}

    fun D.foo() {
        bar()
        baz()
    }

    fun caller(d: D) {
        d.foo()
    }
}

class E {
    fun D.foo2(d: D) {
        toString()
        this@E.toString()
    }
}


