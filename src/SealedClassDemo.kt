import com.sun.tools.corba.se.idl.constExpr.Not

sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotAnNumber : Expr()

fun eval(expr : Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotAnNumber -> 100.toDouble()
}

fun main(args: Array<String>) {
    val a = Const(2.toDouble())
    //val b = Const(5.toDouble())
    val c = Sum(a, NotAnNumber)
    val result = eval(c)
    println(result)
}