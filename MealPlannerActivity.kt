package com.example.seminarproject

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MealPlannerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_planner)

        // assigns variables for interface elements
        val item1Spinner = findViewById<Spinner>(R.id.item1Spinner)
        val item2Spinner = findViewById<Spinner>(R.id.item2Spinner)
        val item3Spinner = findViewById<Spinner>(R.id.item3Spinner)
        val item4Spinner = findViewById<Spinner>(R.id.item4Spinner)
        val item5Spinner = findViewById<Spinner>(R.id.item5Spinner)
        val item6Spinner = findViewById<Spinner>(R.id.item6Spinner)
        val foods : MutableList<String> = ArrayList()

        // fills the spinners with items from the database
        for(i in dataBase.indices)
            foods.add(i,dataBase[i].name + " " + dataBase[i].serving)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, foods)
        item1Spinner.adapter = adapter
        item2Spinner.adapter = adapter
        item3Spinner.adapter = adapter
        item4Spinner.adapter = adapter
        item5Spinner.adapter = adapter
        item6Spinner.adapter = adapter
    }

    fun mealCalcButton(view: View){
        // assigns variables for interface elements
        val calorieTextView = findViewById<TextView>(R.id.calorieTextView)
        val item1Spinner = findViewById<Spinner>(R.id.item1Spinner)
        val item2Spinner = findViewById<Spinner>(R.id.item2Spinner)
        val item3Spinner = findViewById<Spinner>(R.id.item3Spinner)
        val item4Spinner = findViewById<Spinner>(R.id.item4Spinner)
        val item5Spinner = findViewById<Spinner>(R.id.item5Spinner)
        val item6Spinner = findViewById<Spinner>(R.id.item6Spinner)
        val count1Text = findViewById<EditText>(R.id.count1Text)
        val count2Text = findViewById<EditText>(R.id.count2Text)
        val count3Text = findViewById<EditText>(R.id.count3Text)
        val count4Text = findViewById<EditText>(R.id.count4Text)
        val count5Text = findViewById<EditText>(R.id.count5Text)
        val count6Text = findViewById<EditText>(R.id.count6Text)

        // searches the database for the item selected
        val food1 = dataBase.find {it.name + " " + it.serving == item1Spinner.selectedItem.toString()}
        val food2 = dataBase.find {it.name + " " + it.serving == item2Spinner.selectedItem.toString()}
        val food3 = dataBase.find {it.name + " " + it.serving == item3Spinner.selectedItem.toString()}
        val food4 = dataBase.find {it.name + " " + it.serving == item4Spinner.selectedItem.toString()}
        val food5 = dataBase.find {it.name + " " + it.serving == item5Spinner.selectedItem.toString()}
        val food6 = dataBase.find {it.name + " " + it.serving == item6Spinner.selectedItem.toString()}

        // gets the count variables, adjusted to a positive value
        var count1: Int = count1Text.text.toString().toInt()
        var count2: Int = count2Text.text.toString().toInt()
        var count3: Int = count3Text.text.toString().toInt()
        var count4: Int = count4Text.text.toString().toInt()
        var count5: Int = count5Text.text.toString().toInt()
        var count6: Int = count6Text.text.toString().toInt()

        // sums the calorie count of each item selected, multiplied by its count
        var calories = (food1!!.calorie * count1) +
                        (food2!!.calorie * count2) +
                        (food3!!.calorie * count3) +
                        (food4!!.calorie * count4) +
                        (food5!!.calorie * count5) +
                        (food6!!.calorie * count6)

        calorieTextView.text = "Calories: $calories"
    }
}