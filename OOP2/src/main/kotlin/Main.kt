/*
    -inner class
    -inherited class from another class
 */


fun main() {
    val listview = ListView(arrayOf("name1", "name2", "name3"))
    listview.ListViewItems().displayItem(1)
}

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