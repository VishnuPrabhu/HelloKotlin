data class User(val name: String, val age: Int)

data class User2(val name:String = "", val age:Int = 0)

data class Person(val name: String) {
    var age: Int = 0
}

fun main(args: Array<String>) {
    val person1 = Person("John")
    val person2 = Person("John")

    person1.age = 10
    person2.age = 20

    println(person1.equals(person2))

    val jack = User("Jack", 1)
    val olderJack = jack.copy(age = 2)

    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age")
}