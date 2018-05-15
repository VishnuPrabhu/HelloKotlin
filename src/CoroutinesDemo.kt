package vishnu.coroutines

class Foo
class Bar

suspend fun doSomethod(foo: Foo): Bar {
    return Bar()
}

fun <T> async(block: suspend () -> T) {

}

fun main(args: Array<String>) {
//    suspend fun anohterSuspendFunction(sus: suspend () -> Unit) {
//
//    }

    async {
        doSomethod(Foo())
        //anohterSuspendFunction().await()
        //val result = computation.await()

    }

    // doSomethod(Foo()) Error suspending function()
}
interface Base {
    suspend fun foo()
}
class Derived: Base {
    override suspend fun foo() {
        //...
    }
}