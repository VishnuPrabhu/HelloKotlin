interface Base {
    fun print()
    fun foo()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        println("BaseImpl $x")
    }

    override fun foo() {
        println("BaseImpl")
    }
}

class Derived(val a: Base) : Base by a {

    override fun foo() {
        println("Derived-start")
        a.foo()
        println("Derived-end")
    }
}

fun main(args: Array<String>) {
    val base = BaseImpl(10)
    val derived = Derived(base)
    derived.print()
    derived.foo()
}