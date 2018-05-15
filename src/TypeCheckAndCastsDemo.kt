package vishnu.typecheck


fun demoTest() {
    val myObject: Any = "Test"

    if (myObject is String) {
        println("It is a string")
    }

    if (myObject !is String) {
        println("It is a string")
    } else {
        print("String lengght is ${myObject.length}")
    }

//    if (myObject !is String) {
//        return
//    }
//    println(myObject.length)
//
//    if (myObject !is String || myObject.length == 0) return

    when (myObject) {
        is Int -> println(myObject + 1)
        is String -> println(myObject.length)
        is IntArray -> println(myObject.sum())
    }


    // Cast
    val nullValue: Any? = null
    val x: String = nullValue as String
    val xChecked: String? = nullValue as String?

    val xSafeCast: String? = nullValue as? String
}

fun handleStrings(list: List<String>) {
    if (list is ArrayList) {
        val arraylist = list.trimToSize()   // 'list' is smart-cast to 'ArrayList<String>'
    }
}