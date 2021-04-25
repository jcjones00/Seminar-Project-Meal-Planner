package com.example.seminarproject

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MealPlannerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_planner)

        val item1Spinner = findViewById<Spinner>(R.id.item1Spinner)
        val item2Spinner = findViewById<Spinner>(R.id.item2Spinner)
        val item3Spinner = findViewById<Spinner>(R.id.item3Spinner)
        val foods : MutableList<String> = ArrayList()
        for(i in 0..(dataBase.size-1))
            foods.add(i,dataBase[i].name)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, foods)
        item1Spinner.adapter = adapter
        item2Spinner.adapter = adapter
        item3Spinner.adapter = adapter
    }

    fun mealCalcButton(view: View){
        val calorieTextView = findViewById<TextView>(R.id.calorieTextView)
        val item1Spinner = findViewById<Spinner>(R.id.item1Spinner)
        val item2Spinner = findViewById<Spinner>(R.id.item2Spinner)
        val item3Spinner = findViewById<Spinner>(R.id.item3Spinner)

        val food1 = dataBase.find {it.name == item1Spinner.selectedItem.toString()}
        val food2 = dataBase.find {it.name == item2Spinner.selectedItem.toString()}
        val food3 = dataBase.find {it.name == item3Spinner.selectedItem.toString()}
        var calories = food1!!.calorie + food2!!.calorie + food3!!.calorie

        calorieTextView.text = "Calories: $calories"
    }
}