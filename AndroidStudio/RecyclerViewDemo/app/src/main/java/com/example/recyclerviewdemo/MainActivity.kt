package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val randomList = listOf<fruitData>(
        fruitData("chicken", "America"),
        fruitData("doggy", "ASIA"),
        fruitData("cow", "russia"),
        fruitData("lemon", "europe"),
        fruitData("pear", "china"),
        fruitData("orangey", "malaysia"),
        fruitData("cockadoo", "india"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvItems = findViewById<RecyclerView>(R.id.rvItems)
        rvItems.setBackgroundColor(Color.YELLOW)
        //3layout manager, linear(LIST) grid(GRIDS) staggered(STAGGERED GRID)
        //can create custom layout manager
        rvItems.layoutManager = LinearLayoutManager(this)
        //set an adapter class
        rvItems.adapter = RecyclerViewAdapter(randomList) { selectedItem: fruitData ->
            listItemClicked(selectedItem) //function pass object to the function
        }
    }

    //pass this function into adapter
    private fun listItemClicked(fruitSelected: fruitData) {
        Toast.makeText(
            this@MainActivity,
            "Selected fruit ${fruitSelected.nameFruit} by ${fruitSelected.supplierFruit}",
            Toast.LENGTH_SHORT
        ).show()
    }
}