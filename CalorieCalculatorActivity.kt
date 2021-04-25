package com.example.seminarproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class CalorieCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie_calculator)
    }

    fun maleButton(view: View) {
        val maleRadioButton = findViewById<RadioButton>(R.id.maleRadioButton)
        val femaleRadioButton = findViewById<RadioButton>(R.id.femaleRadioButton)
        maleRadioButton.isChecked = true
        femaleRadioButton.isChecked = false
    }

    fun femaleButton(view: View) {
        val maleRadioButton = findViewById<RadioButton>(R.id.maleRadioButton)
        val femaleRadioButton = findViewById<RadioButton>(R.id.femaleRadioButton)
        maleRadioButton.isChecked = false
        femaleRadioButton.isChecked = true
    }

    fun calcButton(view: View) {
        val ageEditText = findViewById<EditText>(R.id.ageText)
        val heightEditText = findViewById<EditText>(R.id.heightText)
        val weightEditText = findViewById<EditText>(R.id.weightText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val femaleRadioButton = findViewById<RadioButton>(R.id.femaleRadioButton)

        var result: Double = 0.0
        val age: Int = Integer.parseInt(ageEditText.text.toString())
        val height: Int = Integer.parseInt(heightEditText.text.toString())
        val weight: Int = Integer.parseInt(weightEditText.text.toString())
        val female: Boolean = femaleRadioButton.isChecked

        result = (10*weight) + (6.25*height) - (5*age) + 5
        if(female){
            result -= 166
        }

        resultTextView.text = "Your daily calorie limit is: $result"
    }
}