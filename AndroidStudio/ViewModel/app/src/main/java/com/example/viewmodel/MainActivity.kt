package com.example.viewmodel

//view model stays in the memory and only cleared when process is killed
//liveData is to get real life updates from data base
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)//provide the life cycle owner

        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btCount = findViewById<Button>(R.id.btCount)

//        tvCount.text = viewModel.count.toString()
        //auto updates now dont need to explicitly call for update
        viewModel.count.observe(this, Observer { tvCount.text = it.toString() })

        btCount.setOnClickListener {
            viewModel.updateCount()
//            tvCount.text = viewModel.count.toString()
        }
    }
}