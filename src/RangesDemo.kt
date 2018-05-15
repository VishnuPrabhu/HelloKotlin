package vishnu.rangedemo

fun demoRange1() {
    val i = 4
    if (i in 0..10) {
        println(i)
    }
    if (i !in 100..110) {
        println("I($i) is not available in the range")
    }

    for (j in 1..4) {
        println(j)
    }
    for (k in 4 downTo 1) {
        println(k)
    }

    for (l in 1..4 step 2) {
        println(l)
    }
    for (m in 4 downTo 1 step 2) {
        println(m)
    }

    for (i in 1 until 10) { // print from 1 to 9,,,,10 is excluded,
        println(i)
    }

    // Range cannot be used for float or double
//    for (p in 1.0..10.0) {
//
//    }

}