package vishnu.destructing

data class Result(val result: Int, val status: String)

fun function(): Result {
    return Result(1, "Ok")
}
fun function2(): Pair<Int, String> {
    val (result, status) = function()
    return Pair(result, status)
}

fun main(args: Array<String>) {
    val (result, status) = function()
    val result2: Pair<Int, String> = function2()

    val collection = ArrayList<Result>()
    for ((result3, status3) in collection) { }

    val (_, statusOnly) = function()

    val map: Map<Int, String> = HashMap<Int, String>()
    map.mapValues { (_, value) -> "$value" }
    map.mapValues { (_, value): Map.Entry<Int, String> -> "$value" }
    map.mapValues { (_, value: String) -> "$value"}
}
