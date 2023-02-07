/*
    - for loop
    - while/ do while
    - continue keyword (bypass everything else in loop and goes to next loop)
    - break keyword (exit loop)
    - myLabel@ // break@myLabel
    - arrays
    - set inlay hints -> settings/inlayhints/types/kotlin/localvariabltypes
 */

fun main() {
    println(sumInt(6, 3, 7, 2, 5, 67, 1, 4))
    /*-------------------------for loops---------------*/
    for (i in 1..10 step 2) { // 1 - 10
        println("i=$i")
    }
    for ( i in 20 until 23){ // 20 - 24
        println("b = $i")
    }
    for (i in 30 downTo  28) { //30 - 25
        println("down = $i")
    }
    var number = 0
    myLabel@ do {
        number ++
        if(number in 3.. 7){
            continue // bypass everything else in loop and goes to next loop
        }
        println(number)
        for ( i in 99..106){
            println("A = $i")
            if (i == 105) break@myLabel
        }
    }while (number<10)

    val nameArray: Array<String> = arrayOf("Ben", "bryan", "rod")
    val randArray = arrayOf(1,2,6,"doggy", 3.6)
    println(nameArray[1])
    for (a in randArray){
        if (a is Double)
            println(a)
    }
}

fun sumInt(vararg numbers: Int): Int {
    var result = 0
    for (a in numbers) {
        result += a
    }
    numbers.forEach { println(it) }
    return result
}