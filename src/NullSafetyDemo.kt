package vishnu.nullsafetydemo

fun testNull() {
    var a: String = "abc"
    //a = null  // throws error because String is not a nullable type

    var b: String? = "abc"
    b = null    // now it is valid because of "String?"

    val l = a.length
    //val m = b.length    // error as b may be null
    val m = b?.length

    val listWithNulls = listOf("1", null)
    for (item in listWithNulls) {
        item?.let { println(it) }

        item?.plus("Kotlin")
    }


    val len = b?.length ?: -1

    val npeLenght = b!!.length

    val aInt: Int? = a as? Int?

    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int>   = nullableList.filterNotNull()

}