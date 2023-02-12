package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import org.w3c.dom.Text

//app that downloads count value-> long runnning tasks
//increases the count value
//there are many coroutines are inside thread

/*
    coroutinescope is global, is the interface to control all coroutines
    Dispatcher.io + job-> is a context
    Dispatchers.Main -> coroutine run in main thread/ UI thread, only for small tasks
    Dispatchers.IO -> coroutine run in a background thread, call database, fetch data
    Dispatchers.Default -> cpu intensive, sorting list, find , parsing huge json file
    Dispatcher.global -> global //not reccomended

    launch -> launches new coroutine without blocking current thread, and returns reference to coroutine, does not return any result value
    async -> launch but returns a value, allows launching in parallel returns a deffered t, require invoke await()
    produce -> coroutines that produce stream of elements
    runblocking -> for testing, thread blocking, returns a result

    structured concurrency-> best practises for coroutines

    suspending functions?? what the hell is that ohh its to change thread to access elements in other thread/activity
    withContext
    withTimeout
    withTimeoutornull
 */
class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var tvMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvMessage = findViewById<TextView>(R.id.tvMessage)
        val textView = findViewById<TextView>(R.id.tvCount)
        val countButton = findViewById<Button>(R.id.btnCount)
        val downloadButton = findViewById<Button>(R.id.btnDownload)

        countButton.setOnClickListener {
            textView.text = count++.toString()
        }
        downloadButton.setOnClickListener {
            //create coroutine
            CoroutineScope(Dispatchers.IO).launch {
                //create coroutine
                downloadUserData()
            }
        }
    }

    //mark function with suspend keyword
    //defined outside the main activity class

    private suspend fun downloadUserData() {
        //simulate a long running tasks
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
            withContext(Dispatchers.Main) {
                tvMessage.text = "Downloading user $i"
            }
//            delay(100)
            //change to thread and display
            //cannot directly call from dispatcher thread to elements in uithread
            //tvMessage.text= "Downloading user $i"
            //switch the coroutine

        }
    }
}

