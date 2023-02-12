class myClass(name: String, age: Int, color: String) {
    var myAge = age
    var myColor = color
    var myName = name.trim()

    fun move(){
        println("$myName am moving")
    }

    fun stop(){
        println("$myColor am stopped")
    }
}

class userClass(var name:String, var lastName: String, var age:Int){
    //initializer blocks
    var insideName: String = ""

    init {
        if (name.lowercase().startsWith("b"))
            this.name = insideName
        else{
            this.name = "user"
            println("init user")
        }
    }
    constructor(name: String ): this(name, "lastname", 3){// if user only provides name
        println("Second")
    }
    constructor(name: String, lastName: String ): this(name, lastName, 100){// if user only provides name and lastname
        println("Third")
    }
}

class anotherClass(firstName: String, var lastName: String = "defaultLastName", var age:Int = 0){
    lateinit var favouriteMovie:String // initialize later

    var firstName: String = firstName
            /*get(){
                return field
            }
            set(value){
                field = value
            }*/ //default get and set functions

        get(){//change get and set functions
            return "FirstName: $field"
        }
        set(value) {
            println("changing value of $field to $value")
            field = value
        }
    fun setFirstNameValue(newValue: String){
        this.firstName = newValue // same as the set function
    }
}

class calculatorClass(){
    companion object{
        fun sum(a: Int, b: Int): Int{
            return a+b
        }
    }
}

class dbClass private constructor() { // private class
    // only one instance should be created
    companion object {
        private var instance: dbClass? = null

        fun getInstance(): dbClass? {
            if (instance == null) {
                instance = dbClass()
            } // if instance is null create the instance
            return instance
        }
    }
}

object dbObject {
    init{ // same as the compianion object instance
        println("database created")
    }
}
