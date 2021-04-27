package com.example.seminarproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodDataActivity : AppCompatActivity() {
    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_data)

        // hooks up the recycler view to the custom adapter
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun prepareItems() {
        // creates a string for each item in the database
        for (i in dataBase.indices) {
            itemsList.add(dataBase[i].name + ", " + dataBase[i].calorie + " calories, " + dataBase[i].serving + ", " + dataBase[i].type)
        }
        customAdapter.notifyDataSetChanged()
    }
}