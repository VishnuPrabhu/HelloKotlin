import javafx.beans.property.ReadOnlyProperty
import jdk.management.resource.ResourceId
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(example: Example, property: KProperty<*>): String {
        return "$example, thank you for delegating ${property.name} to me"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to ${property.name} in $thisRef.")
    }
}

fun mainExample(args: Array<String>) {
    val e = Example()
    e.p = "Hello"
    print(e.p)
}

val lazyValue: String by lazy {
    println("Computed!")
    "Kotlin"
}

fun mainLazy(args: Array<String>) {
    println(lazyValue)
    println(lazyValue)
}

class UserClass {
    var name: String by Delegates.observable("<no_name>") { prop, old, new ->
        println("$old -> $new")
    }

    var age: String by Delegates.vetoable("<no_name>",
        { prop, old, new ->
            println("$old -> $new")
            new.equals("first")
        })

    fun isValid(number: Int) : Boolean {
        return (number > 5)
    }
}

fun mainDelegatedProp(args: Array<String>) {
    val user = UserClass()
    user.name = "first"
    user.name = "second"

    user.age = "first"
    user.age = "second"
    user.age = "third"
}

class UserMap(val map: MutableMap<String, Any>) {
    var name: String by map
    var age: Int by map
}

fun main(args: Array<String>) {
    val map = mutableMapOf<String, Any>(
        "name" to "John Doe",
        "age" to 25
    )

    val user = UserMap(map)
    println(user.name)
    println(user.age)

    user.age = 30
    println(map["age"])
}

fun example(computeUser: () -> UserClass) {
    val memoizedUserClass by lazy(computeUser)

}

/**     Provide Delegate        */
//public class ResourceID<T> {
//    companion object image_id: Int = 6
//
//}
//class ResourceDelegate<T> : ReadOnlyProperty<MyUI, T> {
//    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
//        return null
//    }
//}
//class ResourceLoader<T>(id: ResourceID<T>) {
//
//    operator fun provideDelegate(
//        thisRef: Any?,
//        property: KProperty<*>
//    ) : ReadOnlyProperty<MyUI, T> {
//        //checkProperty
//        return ResourceDelegate<T>()
//    }
//}
//
//class MyUI {
//    fun <T> bindResource(id: ResourceID<T>): ResourceLoader<T> {
//        return ResourceLoader()
//    }
//
//    val image by bindResource(ResourceID<Int>.image_id)
//}