package vishnu.operatoroverloading

import com.sun.org.apache.xpath.internal.operations.Bool


data class Point(val x: Int, val y: Int)
operator fun Point.unaryMinus() = Point(-x, -y)
operator fun Point.inc(): Point {
    val tempX = this.x
    val tempY = this.y
    this.x.inc()
    this.y.inc()
    return Point(tempX, tempY)
}
operator fun Point.compareTo(b: Point): Int {
    return this.x.compareTo(b.x)
}

val point = Point(4, 5)
fun testMinus() {
    val minusPoint = -point;
    println(minusPoint)
}
fun testInc() {
    println("1=${point.x}")
    point.inc()
    println("2=${point.x}")
}

fun main(args: Array<String>) {
    testMinus()
    testInc()

    val a = Point(3,2)
    val b = Point(2,1)

    val compared = b > a
    println(compared)
}