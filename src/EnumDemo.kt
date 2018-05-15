enum class Directions {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000)
}

enum class Protocol {

    WAITING {
        override fun signal(): Protocol {
            return this
        }
    },

    TALKING {
        override fun signal(): Protocol {
            return this
        }
    };


    abstract fun signal(): Protocol
}

enum class RGB { RED, GREEN, BLUE }

inline fun <reified T: Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

fun main(args: Array<String>) {
    val north = Directions.valueOf("NORTH");
    val south = enumValueOf<Directions>("SOUTH")

    println(north.name)
    println(south.ordinal)

    printAllValues<RGB>()

}