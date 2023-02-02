import java.security.KeyStore.TrustedCertificateEntry
import kotlin.math.max

// how to install: get intellij and adoptopenjdk
/* main function for kotlin */
// fun stands for function

//Ctl + Alt + L to auto format the code
fun main() {
    /* ---------Variables----------------*/
    // when hover over it will say explicitly given type is redundant
    var userName: String = "Alex" // variable userName is gonna be of type String
    println("HELLO world")// prints to the console
    println("Hello $userName!") // calling the variable

    val userFixe: String = "Doggy" //val is a variable that cannot be changed, same as const
    userName = "Johnny" // changing the value of the variable
    //userFixe = "money" --> cannot be done

    var ageAlex: Int = 22
    println("Hello $userName, your age is $ageAlex")

    //can just write, do not need to define variable type
    var userName2 = "2nd var name"
    var ageUser = 26
    println("Hello $userName2 = $ageUser")

    var numberMine = 22
    val maxIntegerValue = Int.MAX_VALUE // gets the max value of int
    val minIntegerValue = Int.MIN_VALUE // gets the minimum value
    println("Int max vs min: $maxIntegerValue: $minIntegerValue")
    // numberMine = 2147483648 //error

    val maxByteValue = Byte.MAX_VALUE
    val minByteValue = Byte.MIN_VALUE
    println("Byte max vs min: $maxByteValue: $minByteValue")
    val maxLongValue = Long.MAX_VALUE
    val minLongValue = Long.MIN_VALUE
    println("Long max vs min: $maxLongValue: $minLongValue")
    val maxShortValue = Short.MAX_VALUE
    val minShortValue = Short.MIN_VALUE
    println("Short max vs min: $maxShortValue: $minShortValue")

    val myNumber = 28L // long type
    val myFloat = 2.5f // float
    val myDouble = 6.9 // double

    val myChar: Char = 'C'
    println("my char value $myChar")

    val myBool: Boolean = true
    println("myBool value: $myBool")

    var x = 99
    var y = 45
    x += x
    println("x + y = ${x + y}")// press control d to copy past twice
    println("x + y = ${x / y}")// press control d to copy past twice
    println("x + y = ${x * y}")// press control d to copy past twice
    println("x + y = ${x % y}")// press control d to copy past twice

    println("old x: ${x}")
    println("increments but returns the old x first:${x++}")
    println("increments but returns after increment: ${++x}")

    /* -----------------if else statments----------*/
    var text = if (x == 200) { // assign value based on if else statement
        println("got x = $x")
        "this is text1"
    } else {
        println("x != 200")
        "this is text2"
    }
    println("The text value: $text")
    val newText = if (x > 0) 99 else "x is negative"
    println("new text = $newText")

    /* ---------using When Statments----------*/
    val alarm = 100
    val alarmText = when (alarm) {
        12 -> println("the time is $alarm") //compares the value of alarm with 12
        7 -> println("the time is $alarm")//compares the value of alarm with 7
        14 -> println("the time is $alarm")//compares the value of alarm with 14
        9, 1, 2 -> println("got either 9,1,2 from $alarm") ////compares the value of alarm with 9,1,2
        in 66..99 -> println("got rang 66 to 99 from $alarm") // checks if its within range 66 to 99
        !in 66..99 -> {
            println("got outsid rang 66 to 99 from $alarm")
            println("I got multiple statements")
            "hue"
        } // checks if its within range 66 to 99
        else -> println("the time is $alarm")
    }
    println("Alarmtext: $alarmText")

    val alarm2 = 99
    val alarmText2 = when {
        alarm2 > 12 -> println("the time is $alarm2") //compares the value of alarm with 12
        else -> println("the time is $alarm2")
    }
    println("Alarmtext: $alarmText2")

    /* ------------ NULL ---- */
    var nullText: String? = "Chicken" // it can have  null text if you put question mark at the end of variable type
    if (nullText != null)
        println("nulltext not null $nullText")

    // or
    nullText = "chicken2"
    println(nullText!!.length) //to assign
    nullText = "cock"
    val nullText2 =
        nullText ?: "The variable is null" //assigns $nullText if $nullText is not null else "the variable is null"
    println("the variable is $nullText2")

    /* ------------ Functions ---- */
    sayHello(name = "Alexis", age = 65)
    val largerAB = getMax(a = 34, b = 21)
    println("LargerAb = $largerAB")

    getMax(b = 33, c= 45)
    println("Sum = ${sumVars(1,1,2,1,1,1)}")
}

fun sayHello(name: String, age: Int) {
    println("sayHello: $name with $age")
}

fun getMax(a: Int, b: Int): Int { // return type : Int
    val max = if (a > b) a else b
    return max
}

fun getMax(a: Double, b: Double): Double { // return type : Double, if para a are double it will auto use this function
    val max = if (a > b) a else b
    return max
}

fun getMax(a: Int = 99, b: Int, c:Int): Int { // if there are 3 parameters, it will auto use this function with default
    val max = if (a > b) a else b
    return max
}

fun sumVars(vararg  numbers: Int): Int { // there are UnKnown number of parameters
    var result = 0
    numbers.forEach { println(it) } //for each loop
    for (i in numbers){
        result += i
    }
    return result
}

fun getMin(a: Int, b: Int) = if (a < b) a else b //single line function code, return type can be inferred