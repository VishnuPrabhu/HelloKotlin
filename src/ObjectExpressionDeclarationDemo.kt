package vishnu.objectexpr

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JComponent


val window: Window? = null;
fun main(args: Array<String>) {
    window?.addMouseListener(object : MouseListener {
        override fun mouseReleased(e: MouseEvent?) {
        }

        override fun mouseEntered(e: MouseEvent?) {
        }

        override fun mouseClicked(e: MouseEvent?) {
        }

        override fun mouseExited(e: MouseEvent?) {
        }

        override fun mousePressed(e: MouseEvent?) {
        }

    })
}

open class A public constructor(x: Int) {
    open val y:Int = x
}
interface B { }

val a: A = object: A(1), B {
    override val y: Int = 15
}

fun foo() {
    val adHoc = object {
        val x: Int = 0
        val y: Int = 0
    }

    println("$adHoc.x, $adHoc.y")
}

class C {
    private fun foo() = object {
        val x: String = "x"
    }

    fun publicFoo() = object {
        val x:String = "x"
    }

    fun bar() {
        println(foo().x)
        //println(publicFoo().x)    // error, cannot access x
    }
}


fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window?.addMouseListener(object: MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent?) {
            super.mouseEntered(e)
            enterCount++
        }
    })
}

/**     Object Declaration      */
object StringDataProviderManager {
    fun registerProvider(provider: String) {

    }

    val allProviders: List<String> = ArrayList<String>()
}

fun test1() {
    StringDataProviderManager.allProviders
    StringDataProviderManager.registerProvider("default")
}

/**     Companion Object      */
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}
class MyClass2 {
    companion object {
        fun create(): MyClass2 = MyClass2()
    }
}

interface Factory<T> {
    fun create(): T
}
class MyClass3 {
    companion object : Factory<MyClass3> {
        override fun create(): MyClass3 = MyClass3()
    }
}

fun mainCompanion() {
    val instance = MyClass.create()

    val x = MyClass2.Companion
    x.create()
    val x2 = MyClass2.create()


}