package com.example.seminarproject

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round

class CalorieCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie_calculator)
    }

    fun uscButton(view: View) {
        // assigns variables for interface elements
        val uscButton = findViewById<RadioButton>(R.id.uscButton)
        val metricButton = findViewById<RadioButton>(R.id.metricButton)
        val heightEditText = findViewById<EditText>(R.id.heightText)
        val weightEditText = findViewById<EditText>(R.id.weightText)

        heightEditText.hint = "Height (in)"
        weightEditText.hint = "Weight (lbs)"
        uscButton.isChecked = true
        metricButton.isChecked = false
    }

    fun metricButton(view: View) {
        // assigns variables for interface elements
        val uscButton = findViewById<RadioButton>(R.id.uscButton)
        val metricButton = findViewById<RadioButton>(R.id.metricButton)
        val heightEditText = findViewById<EditText>(R.id.heightText)
        val weightEditText = findViewById<EditText>(R.id.weightText)

        heightEditText.hint = "Height (cm)"
        weightEditText.hint = "Weight (kg)"
        uscButton.isChecked = false
        metricButton.isChecked = true
    }

    fun maleButton(view: View) {
        // assigns variables for interface elements
        val maleRadioButton = findViewById<RadioButton>(R.id.maleRadioButton)
        val femaleRadioButton = findViewById<RadioButton>(R.id.femaleRadioButton)

        maleRadioButton.isChecked = true
        femaleRadioButton.isChecked = false
    }

    fun femaleButton(view: View) {
        // assigns variables for interface elements
        val maleRadioButton = findViewById<RadioButton>(R.id.maleRadioButton)
        val femaleRadioButton = findViewById<RadioButton>(R.id.femaleRadioButton)

        maleRadioButton.isChecked = false
        femaleRadioButton.isChecked = true
    }

    fun calcButton(view: View) {
        // assigns variables for interface elements
        val ageEditText = findViewById<EditText>(R.id.ageText)
        val heightEditText = findViewById<EditText>(R.id.heightText)
        val weightEditText = findViewById<EditText>(R.id.weightText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val femaleRadioButton = findViewById<RadioButton>(R.id.femaleRadioButton)
        val uscButton = findViewById<RadioButton>(R.id.uscButton)

        // reads from user inputs
        val age: Int = Integer.parseInt(ageEditText.text.toString())
        var height: Double = heightEditText.text.toString().toDouble()
        var weight: Double = weightEditText.text.toString().toDouble()
        val female: Boolean = femaleRadioButton.isChecked
        val usc: Boolean = uscButton.isChecked

        var result: Double = 0.0

        // converts USC to metric
        if(usc){
            height *= 2.54
            weight *= 0.4535924
        }

        // calculates BMR with metric units
        result = (10*weight) + (6.25*height) - (5*age) + 5
        if(female){
            result -= 166
        }

        // displays the result
        var resultInt: Int = round(result).toInt()
        resultTextView.text = "Your daily calorie limit is: $resultInt"

        // hides the keyboard
        val inputMethodManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.applicationWindowToken, 0)
    }
}