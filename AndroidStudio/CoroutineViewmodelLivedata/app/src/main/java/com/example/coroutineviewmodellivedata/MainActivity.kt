package com.example.coroutineviewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    //get view model instance
    private lateinit var mainActivityViewModel: ViewModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get view model instance
        mainActivityViewModel = ViewModelProvider(this).get(ViewModelClass::class.java)

        mainActivityViewModel.getUserData()
        //observe the list of users data
        mainActivityViewModel.userDataList.observe(this, Observer {
            //get the list of users as myUsers
                myUsers ->
            if (myUsers != null) {
                myUsers.forEach {
                    Log.i("MyTage", "${it.id} is ${it.name}")
                }
            }
        })

    }
}