package vishnu.functionsinline


// return from method with lambda expression
fun hasZeroes(ints: List<Int>): Boolean {
    ints.forEach{
        if (it == 0) {
            return true
        }
    }
//    ints.forEach ret@{
//        if (it == 0) {
//            return@ret
//        }
//    }
    return false
}
/** break and continue are not yet available in inlined lambdas, but we are planning to support them too. */
inline fun f(crossinline body: () -> Unit) {
    val f = Runnable {
        body()
    }
}


fun check(string: CharSequence) {
    println("charsequence")
}

fun check(string: String) {
    println("string")
}

fun mainCheck(args: Array<String>) {
    check("Hello")
    check("Hello" as CharSequence)
}

class TreeNode {
    var child = TreeNode()
}
val parent: TreeNode = TreeNode()

inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.child
    }
    return p as T?
}

/***/
inline fun <reified T> membersOf() = T::class.members


fun mainReified() {
    TreeNode().findParentOfType<TreeNode>()

    membersOf<StringBuilder>().joinToString { "\n" }
}
