package edu.miu.cs473.cvbuilder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val preferenceName = "LoginPreference"


    private lateinit var emailAddressField: EditText
    private lateinit var passwordField: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        emailAddressField = findViewById(R.id.email_edit_text)
        passwordField = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener(this::attemptLogin)
    }

    private fun attemptLogin(view: View) {
        val preference = getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
        val email = preference.getString("email", null)
        val password = preference.getString("password", null)

        val inputEmail = emailAddressField.text.toString().trim()
        val inputPassword = passwordField.text.toString().trim()

        if (inputEmail.isEmpty()) {
            showError("Email cannot be empty")
            return
        }

        if (inputPassword.isEmpty()) {
            showError("Password cannot be empty")
            return
        }

        if (email == null) {
            val editor = preference.edit()
            editor.putString("email", inputEmail)
            editor.putString("password", inputPassword)
            editor.apply()
            showMainScreen()
        } else {
            if (inputPassword != password || inputEmail != email) {
                showError("Email / Password invalid")
                return
            }
            showMainScreen()
        }
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finishAffinity()
    }
}

