package vishnu.reflectionsdemo

import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

class MyClass

fun test() {
    val c = MyClass::class
    val cJava = MyClass::class.java

    open class Widget
    class GoodWidget : Widget()
    class BadWidget : Widget()

    val widget: Widget = GoodWidget()
    assert(widget is GoodWidget) { "BadWidget: ${widget::class.qualifiedName}" }
}

fun isOdd(x: Int): Boolean = x % 2 == 0
val numbers = listOf(1, 2, 3, 4)
fun testDoubleColonInLambda() {
    val oddNumbers = numbers.filter(::isOdd)

    val predicate: (Int) -> Boolean = ::isOdd
    val oDD = numbers.filter(predicate)
    testExtensionMemberReference(String::myCharArray)
}

fun String.myCharArray(): CharArray {
    return this.toCharArray()
}
//fun testExtensionMemberReferen(myFun: String.() -> CharArray) {
fun testExtensionMemberReference(myFun: (String) -> CharArray) {
    myFun("Hello")
}

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): ((A) -> C) {
    return { x -> f(g(x)) }
}

fun length(s: String): Int = s.length
val oddLength = compose(::isOdd, ::length)
val strings = listOf("a", "ab", "abc")
fun testFunctionCompose() {
    strings.filter(oddLength)
}


/** Property References */
val x = 1
var y = 1
fun testProperty() {
    println(::x.get())
    println(::x.name)

    ::y.set(2)
    println(y)

    println(strings.map(String::length))
}


class A(val p: Int)
val String.lastChar: Char
    get() = this[length -1]

fun testKPropertyAccessors() {
    val prop = A::p
    println(prop.get(A(1)))

    println(String::lastChar.get("abc"))
}

fun testInterOp() {
    class A(val p: Int)
    println(A::p.javaGetter)
    print(A::p.javaField)
}
fun testJavaKotlinInterOp() {
    fun getClass(o: Any): KClass<Any> = o.javaClass.kotlin
}

// construction passing
class Foo
fun functionFoo(factory: () -> Foo) {
    val x: Foo = factory()
}
fun testFactory() {
    functionFoo(::Foo)
}

// Refer Instance
fun testFunctionMember() {
    val numberRegex = "\\d".toRegex()
    println(numberRegex.matches("29"))

    val isNumber = numberRegex::matches
    println(isNumber("29"))

    val myStrings = listOf("abc", "123", "alpha123")
    println(myStrings.filter(numberRegex::matches))
}