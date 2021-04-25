package com.example.seminarproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Food(var name: String, var calorie: Int, var serving: String, var type: String){}

val dataBase = arrayOf<Food>(
        Food("None",0,"Nothing","Nothing"),
    Food("Apple",59,"1 (4 oz.)","Fruit"),
    Food("Banana",151,"1 (6 oz.)","Fruit"),
    Food("Grapes",100,"1 cup","Fruit"),
    Food("Orange",53,"1 (4 oz.)","Fruit"),
    Food("Pear",82,"1 (5 oz.)","Fruit"),
    Food("Peach",67,"1 (6 oz.)","Fruit"),
    Food("Pineapple",82,"1 cup","Fruit"),
    Food("Strawberry",53,"1 cup","Fruit"),
    Food("Watermelon",50,"1 cup","Fruit"),
    Food("Asparagus",27,"1 cup","Vegetables"),
    Food("Broccoli",45,"1 cup","Vegetables"),
    Food("Carrots",50,"1 cup","Vegetables"),
    Food("Cucumber",17,"4 oz.","Vegetables"),
    Food("Eggplant",35,"1 cup","Vegetables"),
    Food("Lettuce",5,"1 cup","Vegetables"),
    Food("Tomato",22,"1 cup","Vegetables"),
    Food("Beef, regular, cooked",142,"2 oz.","Proteins"),
    Food("Chicken, cooked",136,"2 oz.","Proteins"),
    Food("Tofu",86,"4 oz.","Proteins"),
    Food("Egg",78,"1 large","Proteins"),
    Food("Fish, Catfish, cooked",136,"2 oz.","Proteins"),
    Food("Pork, cooked",137,"2 oz.","Proteins"),
    Food("Shrimp, cooked",56,"2 oz.","Proteins"),
    Food("Bread, white",75,"1 slice (1 oz.)","Common Meals/Snacks"),
    Food("Butter",102,"1 tablespoon","Common Meals/Snacks"),
    Food("Caesar salad",481,"3 cups","Common Meals/Snacks"),
    Food("Cheeseburger",285,"1 sandwich","Common Meals/Snacks"),
    Food("Hamburger",250,"1 sandwich","Common Meals/Snacks"),
    Food("Dark Chocolate",155,"1 oz.","Common Meals/Snacks"),
    Food("Corn",132,"1 cup","Common Meals/Snacks"),
    Food("Pizza",285,"1 slice (14 inches)","Common Meals/Snacks"),
    Food("Potato",130,"6 oz.","Common Meals/Snacks"),
    Food("Rice",206,"1 cup cooked","Common Meals/Snacks"),
    Food("Sandwich",200,"1 (6 inch Subway Turkey Sandwich)","Common Meals/Snacks"),
    Food("Beer",154,"1 can","Beverages/Dairy"),
    Food("Coca-Cola Classic",150,"1 can","Beverages/Dairy"),
    Food("Diet Coke",0,"1 can","Beverages/Dairy"),
    Food("Milk (1%)",102,"1 cup","Beverages/Dairy"),
    Food("Milk (2%)",122,"1 cup","Beverages/Dairy"),
    Food("Milk (Whole)",146,"1 cup","Beverages/Dairy"),
    Food("Orange Juice",111,"1 cup","Beverages/Dairy"),
    Food("Apple cider",117,"1 cup","Beverages/Dairy"),
    Food("Yogurt (low-fat)",154,"1 cup","Beverages/Dairy"),
    Food("Yogurt (non-fat)",110,"1 cup","Beverages/Dairy")
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calorieCalculatorButton(view: View) {
        val intent = Intent(this, CalorieCalculatorActivity::class.java)
        startActivity(intent)
    }

    fun foodDataButton(view: View) {
        val intent = Intent(this, FoodDataActivity::class.java)
        startActivity(intent)
    }

    fun mealPlannerButton(view: View) {
        val intent = Intent(this, MealPlannerActivity::class.java)
        startActivity(intent)
    }
}