import java.lang.Exception
import javax.naming.InvalidNameException

/*
    -inner class
    -inherited class from another class add open
        open class MainClass()
        class inheritor():MainClass
    -overwrite inherited class function by adding open
        code/generate/overwrite methods
        overwrite fun
    -Sealed classses
 */


fun main() {
    val listview = ListView(arrayOf("name1", "name2", "name3"))
    listview.ListViewItems().displayItem(1)

    val cars = Car1("mine", "white", 35)
    cars.move() //functions have been inherited
    cars.stop()

    val success = Result.Sucesss("suxxxess")
    val error = Result.Error.NonrecoverableError(exception= InvalidNameException, message = "invalid name")
    getData(error)

}

fun getData(ab: Result) {
    when (ab) {
        is Result.Sucesss -> ab.showMessageSucess()
        is Result.Progress -> ab.showMessageProgress()
        is Result.Error.NonrecoverableError -> ab.showMessageError()
        is Result.Error.RecoverableError -> ab.showMessageError()
    }
}

sealed class Result(val message: String) {
    fun showMessageSucess() {
        println("sucess Result: $message")
    }

    fun showMessageError() {
        println("error Result: $message")
    }

    fun showMessageProgress() {
        println("progress Result: $message")
    }

    class Sucesss(message: String) : Result(message)
    sealed class Error(message: String) : Result(message){
        class RecoverableError(exception: Exception, message: String): Error(message)
        class NonrecoverableError(exception: Exception, message: String):Error(message)
    }
    class Progress(message: String) : Result(message)

}



