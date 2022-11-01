package edu.miu.cs473.walmartapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
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

class RegistrationActivity : AppCompatActivity() {

    private lateinit var firstNameField: EditText
    private lateinit var lastNameField: EditText
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var createAccountButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firstNameField = findViewById(R.id.first_name_edit_text)
        lastNameField = findViewById(R.id.last_name_edit_text)
        emailField = findViewById(R.id.email_edit_text)
        passwordField = findViewById(R.id.password_edit_text)
        createAccountButton = findViewById(R.id.create_account_button)

        createAccountButton.setOnClickListener(this::onCreateAccountButtonClicked)
    }

    private fun onCreateAccountButtonClicked(view: View) {
        val firstName = firstNameField.text?.toString()?:"".trim()
        val lastName = lastNameField.text?.toString()?:"".trim()
        val email = emailField.text?.toString()?:"".trim()
        val password = passwordField.text?.toString()?:"".trim()

        if (firstName.isEmpty() || lastName.isEmpty() ||
                email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val intent = Intent()
        intent.putExtra("user", User(firstName, lastName, email, password))
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}