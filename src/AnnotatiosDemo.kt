// File Annotation
@file:JvmName("")


package vishnu.annotationsdemo

import kotlin.reflect.KClass

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy

@Fancy
class Foo @Fancy constructor() {
    @Fancy
    fun baz(@Fancy foo: Int): Int {
        return (@Fancy 1)
    }

    @Fancy
    val x: String
        @Fancy get() = ""
}

@Target(AnnotationTarget.CLASS)
annotation class Special(val why: String)

@Special("Example") class Foos { }


annotation class ReplaceWith(val value: String)
annotation class Deprecated(
    val message: String,
    val replaceWith: ReplaceWith = ReplaceWith("")
)
//useage
@Deprecated("This function is Deprecated, use === instead", ReplaceWith("this === other"))
fun test() { }


annotation class Ann(val arg1: KClass<*>, val arg2: KClass<out Any>)
@Ann(String::class, Int::class)
class MyClass


annotation class Suspendable
val f = @Suspendable { Thread.sleep(1000) }


annotation class AnnotationTest
class Example(
    @field:AnnotationTest val foo: Int, @param:AnnotationTest val bar: Int,
    @get:AnnotationTest val quxx: Int
) {
    @set:[AnnotationTest Ann(Int::class, String::class)]
    var collaburator: String = ""


    //fun @AnnotationTest String.myExtension() { }
}

//// Java
//public @interface Ann {
//    int intValue();
//    String stringValue();
//}
//// Kotlin
//@Ann(intValue = 1, stringValue = "abc") class C

//// Java
//public @interface AnnWithValue {
//    String value();
//}
//// Kotlin
//@AnnWithValue("abc") class C

// Java
//public @interface AnnWithArrayValue {
//    String[] value();
//}
//// Kotlin
//@AnnWithArrayValue("abc", "foo", "bar") class C


//// Java
//public @interface AnnWithArrayMethod {
//    String[] names();
//}
//// Kotlin 1.2+:
//@AnnWithArrayMethod(names = ["abc", "foo", "bar"])
//class C
//
//// Older Kotlin versions:
//@AnnWithArrayMethod(names = arrayOf("abc", "foo", "bar"))
//class D

//// Java
//public @interface Ann {
//    int value();
//}
//// Kotlin
//fun foo(ann: Ann) {
//    val i = ann.value
//}