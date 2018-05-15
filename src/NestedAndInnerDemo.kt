import java.awt.event.ActionListener

class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }
}

fun main(args: Array<String>) {
    val demo = Outer.Nested().foo()

    val algoList = ActionListener { e -> println(e.actionCommand)}

    // https://youtrack.jetbrains.com/issue/KT-7770
    //val myObject = MyActionListener { e -> println(e)}
    val myObject = object : MyActionListener {
        override fun actionPerformed(e: String) {
            println(e)
        }
    }
}

interface MyActionListener  {

    /**
     * Invoked when an action occurs.
     */
    fun actionPerformed(e: String)

}
