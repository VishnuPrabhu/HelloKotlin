package vishnu.thisexpression

class A { // implicit label A

    inner class B { // Implicit label B

        fun Int.foo() {
            val a = this@A // A's this
            val b = this@B // B's this

            val c = this // Int's receiver as this
            val c1 = this@foo // same as above


            val funLit = lambda@ fun String.() {
                val d = this
            }

            val funLit2 = { s: String ->
                val d = this
            }
        }

    }

}