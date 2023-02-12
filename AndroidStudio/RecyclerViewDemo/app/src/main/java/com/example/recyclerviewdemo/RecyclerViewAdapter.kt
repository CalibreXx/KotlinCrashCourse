package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//unit means return nothing
//kotlin lambda expressions
class RecyclerViewAdapter(
    private val randomList: List<fruitData>,
    private val clickListener: (fruitData) -> Unit
) : RecyclerView.Adapter<myViewHolder>() {
    //define list of random strings

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        //get thelayout template
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return myViewHolder(listItem)
    }

    override fun onBindViewHolder(myHolder: myViewHolder, position: Int) {
        val fruit = randomList[position]
        myHolder.bind(fruit, clickListener)
        //used to display data
    }

    //returns total number of itmes in the data set
    override fun getItemCount(): Int {
        return randomList.size //tell recycler view number of items
    }
}

class myViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(selectedFruit: fruitData, clickListener: (fruitData) -> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvTitle)
        myTextView.text = selectedFruit.nameFruit

        //add click listener to recycleview items
        //bad method, the fruit object is stuck in this adapter, will want to send it to main activity
        view.setOnClickListener {
            //        Toast.makeText(
            //            this@MainActivity,
            //            "Selected fruit ${fruitSelected.nameFruit} by ${fruitSelected.supplierFruit}",
            //            Toast.LENGTH_SHORT
            //        ).show()
            clickListener(selectedFruit)
        }
    }
}