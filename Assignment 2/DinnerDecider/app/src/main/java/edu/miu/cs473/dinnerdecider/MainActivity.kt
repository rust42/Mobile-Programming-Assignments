package edu.miu.cs473.dinnerdecider

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import edu.miu.cs473.dinnerdecider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val dinnerMenus = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    private lateinit var decideButton: Button
    private lateinit var selectedMenu: TextView
    private lateinit var addFoodEditText: EditText
    private lateinit var addFoodButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decideButton = findViewById(R.id.decide_button)
        selectedMenu = findViewById(R.id.selectedMenu)
        addFoodEditText = findViewById(R.id.add_food_edit_text)
        addFoodButton = findViewById(R.id.add_food_button)

        decideButton.setOnClickListener {
            val randomItem = dinnerMenus.random()
            selectedMenu.text = randomItem
        }

        addFoodButton.setOnClickListener {
            val text = addFoodEditText.text.toString()
            if (text.isNotEmpty()) {
                dinnerMenus.add(text)
                addFoodEditText.setText("")
                selectedMenu.text = text
            }
        }
    }
}