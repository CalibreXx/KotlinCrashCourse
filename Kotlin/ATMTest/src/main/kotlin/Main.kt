//account name
//balance
// transaction

//deposit, balance, withdrawal

fun main() {
    val Alexaccount = Account("Alex")
    Alexaccount.deposit(100)
    Alexaccount.withdrawal(30)
    println(Alexaccount.calculateBalance())
}

class Account(val accountName: String) {
    private var balance = 0 //prevents it from being editable from outside
    private var transactions = mutableListOf<Int>()

    fun deposit(amount: Int) {
        if (amount > 0) {
            transactions.add(amount)
            this.balance += amount
        }
    }

    fun withdrawal(amount: Int) {
        if (amount > 0) {
            transactions.add(-amount)
            this.balance -= amount
        }
    }

    fun calculateBalance(): Int {
        this.balance = 0
        for (a in transactions) {
            this.balance += a
        }
        return this.balance
    }
}