/*
    OOP
    - class
        - hover over variable, click lightbulb, move to constructor, initialize values in constructor --> cannot be edited
    - string.trim
    - declare class in another file
    - init statement // initialize or optional parameters
    - rightclick on variable name --> refactor --> rename (shift+f6) to change every instance
    - getters and setters
    - companion object
    - single instance classses singleton
    - lazy initializaiton
    - enum
 */

fun main() {
    val car1 = myClass("     gotcha", age = 234, color = "red")
    car1.myAge = 69

    car1.myColor = "niggar"
    car1.move()

    val user1 = userClass(name = "cen", lastName = "benny", age = 3054)
    val user2 = userClass(name = "cock")
    println(user2.lastName)
    val user3 = userClass(name = "cock", lastName = "wassup")

    val user4 = anotherClass(firstName = "doggyyy", lastName = "poopy", age = 234)
    user4.firstName = "changed"
    println("firstname: ${user4.firstName}")
    user4.favouriteMovie = "Inception" //late variable

    val myCalculator = calculatorClass()
    //using companion object

    val instance = dbClass.getInstance()
    println(instance)
    val instance2 = dbClass.getInstance()
    println(instance2) // outputs the same instance as alrdy created
    println(dbObject) // only inits this one time
    println(dbObject)

    //7.20h
    val user5 = myClass2("user5", age = 35, color = "red")
    val user6 by lazy {
        myClass2("user6", 69, "black") // object is not initialized
    }
    println(user6)

//    println(directionClass.NORTH)
//    println(directionClass.EAST)
//    println(directionClass.SOUTH)
//    println(directionClass.WEST)
    for ( a in directionClass.values()){
        println(a)
    }
    println(directionClass.EAST.direction)
    println(directionClass.EAST.distance)
    println(directionClass.WEST.printData())

    val directional = directionClass.WEST
    when(directional){ //similar to switch case
        directionClass.WEST -> println("the direction is West")
        directionClass.EAST-> println("The direction is east")
        directionClass.NORTH-> println("The direction is NORTH")
        directionClass.SOUTH-> println("The direction is SOUTH")
    }

    val direction = directionClass.valueOf("EAST")
    println(direction)
}

class myClass2(name: String, age: Int, color: String) {
    init {
        println("myClass2 created user:$name")
    }
}

enum class directionClass(var direction: String, var distance: Int){
    NORTH("north", 10),
    SOUTH("south", 33),
    EAST("east", 64),
    WEST("west", 64);

    fun printData(){
        println("Direction = $direction and $distance")
    }
}

