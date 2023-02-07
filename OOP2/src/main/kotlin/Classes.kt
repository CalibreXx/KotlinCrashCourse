
class ListView(val items: Array<String>) {
    inner class ListViewItems() {
        fun displayItem(position: Int) {
            //inner classs have acess to outer class
            println(items[position])
        }
    }
}

class Car(val name: String, val color: String, val engines: Int) {
    fun move(){
        println("$name is moving")
    }
    fun stop(){
        println("$name is stopped")
    }
}

class Plane (val name: String, val color: String, val engines: Int){ //same as the above!!!!
    fun move(){
        println("$name is moving")
    }
    fun stop(){
        println("$name is stopped")
    }
}

open class Vehicles(val name: String, val color: String){
    open fun move(){
        println("$name is moving")
    }
    open fun stop(){
        println("$name is stopped")
    }
}

class Car1(name: String, color: String, val engines: Int) : Vehicles (name, color){
    override fun move() {
        flying() // new function
        super.move() // old function
    }
    fun flying(){
        println("$name is driving")
    }
}