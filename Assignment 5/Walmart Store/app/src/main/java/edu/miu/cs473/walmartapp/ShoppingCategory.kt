package edu.miu.cs473.walmartapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import edu.miu.cs473.walmartapp.databinding.ActivityShoppingBinding

class ShoppingCategory : AppCompatActivity() {

    private lateinit var usernameTextView: TextView
    private lateinit var electronicsButton: ImageButton
    private lateinit var clothingButton: ImageButton
    private lateinit var beautyButton: ImageButton
    private lateinit var foodButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        electronicsButton = findViewById(R.id.electronics_button)
        clothingButton = findViewById(R.id.clothing_button)
        beautyButton = findViewById(R.id.beauty_button)
        foodButton = findViewById(R.id.food_button)

        electronicsButton.setOnClickListener(::onCategoryButtonClicked)
        clothingButton.setOnClickListener(::onCategoryButtonClicked)
        beautyButton.setOnClickListener(::onCategoryButtonClicked)
        foodButton.setOnClickListener(::onCategoryButtonClicked)


        val user = intent.getParcelableExtra<User>("user")

        usernameTextView = findViewById(R.id.username_textview)
        usernameTextView.text = user?.username
    }

    private fun onCategoryButtonClicked(view: View) {

        when(view) {
            electronicsButton -> showProductsList(SelectedCategory.Electronics)
            clothingButton -> showProductsList(SelectedCategory.Clothing)
            beautyButton -> showProductsList(SelectedCategory.Beauty)
            foodButton -> showProductsList(SelectedCategory.Food)
        }
    }

    private fun showProductsList(category: SelectedCategory) {
        val intent = Intent(this, ProductsActivity::class.java)
        intent.putExtra(ProductsActivity.SelectedCategoryKey, category.value)
        startActivity(intent)
    }
}