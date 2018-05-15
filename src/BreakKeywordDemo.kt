import javafx.beans.property.ReadOnlyProperty

fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach lit@{
//        if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop
//        print(it)
//    }
//    // We need ot use break instead of return in this logic
    var listOf5 = listOf(1, 2, 3, 4, 5)
//    brk@ for (it: Int in listOf5) {
//        if (it == 3) return@brk // local return to the caller of the lambda, i.e. the forEach loop
//        print(it)
//    }
//    listOf5.forEach {
//        if (it == 3) return@forEach
//        print("Test $it, ")
//    }
    listOf5.forEach(fun(value: Int) {
        if (value == 3) return
        println(value)
    })
    print(" done with explicit label")
}

fun main(args: Array<String>) {
    foo()
}

