import javafx.scene.Parent
import org.jetbrains.annotations.NotNull

///////////////////
/**Classes*/
/**Constructors*/
///////////////////
/*
class InitOrderDemo(name: String) {
    val firstProperty = "First Property: $name".also(::println)
    init {
        println("First Initializer block that prints $name")
    }
    val secondProperty = "Second Property: ${name.length}".also(::println)
    init {
        println("Second initializer block that prints ${name.length}")
    }
}

fun main(args: Array<String>) {
    InitOrderDemo("hello")
}

class Customer(name:String) {
    val customerKey = name.toUpperCase()
}

class Person(val firstName: String, val lastName: String, var age: Int) {

}

class Customer public @SafeVarargs constructor(name: String) {

}

class Person(name: String) {
    val children: ArrayList<Person> = ArrayList<Person>()
    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}


class Constructors {
    init {
        println("Init Block")
    }

    constructor(i: Int) {
        println("constructor")
    }
}

class DontCreateMe private constructor() {

}

class Example

open class Base(p: Int) {
    open fun v() {}
    fun nv() {}
}

class Derived(p: Int) : Base(p) {
    override fun v() {
        super.v()
    }
}

open class AnotherDerived(p: Int) : Base(p) {
    final override fun v() {
        super.v()
    }
}

open class Foo {
    open val x: Int get() { return 0 }
}

class Bar1: Foo() {
    override var x: Int = 5
}

interface Foo {
    val count: Int
}

class Bar1(override val count: Int) : Foo {

}

class Bar2 : Foo {
    override val count: Int
        get() = 4
}

open class Base(name: String) {
    init {
        println("Initializing Base")
    }

    open val size: Int = name.length.also { println("Initializing size in Base : $it") }
}
class Derived(name: String, val lastname: String) : Base(name) {
    init {
        println("Initializing Derived")
    }

    val size3: Int = (super.size + lastname.length).also { println("${super.size} is BaseSize & ${super.size + size} is Derived Size") }

    override val size: Int =
        (super.size + lastname.length).also { println("Initializing size in Derived: $it") }
}

open class Foo {
    open val x: Int = 1
    open fun f() {
        print("FOO")
    }
}
class Bar : Foo() {
    override val x: Int = 2
    override fun f() {
        super.f()
    }

    inner class Baz {
        fun g() {
            super@Bar.f()
            println(super@Bar.x)
        }
    }
}

open class A {
    open fun f() {println("Print A")}
}
interface B {
    fun f() {println("print B")}
}
class C : A(), B {
    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}
*/
///////////////////
/*
class Person constructor(firstName: String) {

}
class Person(firstName: String) {

}
*/
///////////////////
///////////////////
/**MainFunction common for All Implementations*/
///////////////////
fun main(args: Array<String>) {
    //1
    // Constructors(1)
    //2
    println("Constructing Derived(\"hello\", \"world\")")
    //val d = Derived("hello", "world")

}



