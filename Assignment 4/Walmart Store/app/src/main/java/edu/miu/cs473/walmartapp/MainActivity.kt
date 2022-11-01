package edu.miu.cs473.walmartapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


data class UsernamePasswordNotFoundException(val name: String): Exception(name)

class MainActivity : AppCompatActivity() {

    private val users = mutableListOf<User>(
        User("Sandeep", "Koirala", "sndpkrl007@gmail.com", "s3cr3t1"),
        User("Rajiv", "Gyawali", "raymond.g@gmail.com", "s3cr3t2"),
        User("Jenish", "Ghimire", "jghimire@gmail.com", "s3cr3t3"),
        User("Binod", "Pant", "pantbinod@gmail.com", "s3cr3t4"),
        User("Prabeen", "Soti", "prabeen.soti@gmail.com", "s3cr3t5"),
    )
    private lateinit var signInButton: Button
    private lateinit var createAccountButton: Button
    private lateinit var usernameField: EditText
    private lateinit var passwordField: EditText
    private lateinit var forgotPasswordText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInButton = findViewById(R.id.sign_in_button)
        createAccountButton = findViewById(R.id.create_account_button)
        usernameField = findViewById(R.id.email_edit_text)
        passwordField = findViewById(R.id.password_edit_text)
        forgotPasswordText = findViewById(R.id.forgot_password_text)

        forgotPasswordText.setOnClickListener(::forgotPassword)

        val registrationLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK)  {
                val intent = result.data
                val user = intent?.getParcelableExtra<User>("user")

                if (user != null) {
                    users.add(user)
                    Toast.makeText(this, "User: ${user.username} successfully added !}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        createAccountButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            registrationLauncher.launch(intent)
        }

        signInButton.setOnClickListener {
            try {
                attemptLogin()
            } catch (ex: UsernamePasswordNotFoundException) {
                Toast.makeText(applicationContext, "Exception: " + ex.message, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    private fun attemptLogin() {
        val username = usernameField.text.toString().trim()
        val password = passwordField.text.toString().trim()

        if (username.isEmpty() || password.isEmpty()) {
            throw UsernamePasswordNotFoundException("Username / password cannot be empty")
        }

        try {
            val user = users.first { it.username == username }
            if (user.password != password) {
                throw UsernamePasswordNotFoundException("Cannot find password")
            }
            presentCategoryView(user)
        } catch(ex: NoSuchElementException) {
            throw UsernamePasswordNotFoundException("Cannot find username")
        }
    }

    private fun presentCategoryView(user: User) {
        val intent = Intent(this, ShoppingCategory::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    private fun forgotPassword(view: View) {
        val emailText = usernameField.text.trim()
        if (emailText.isEmpty()) {
            return
        }

        val user = users.first { it.username == emailText }

        val emailSelectorIntent = Intent(Intent.ACTION_SENDTO)
        emailSelectorIntent.data = Uri.parse("mailto:")


        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailText))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Forgotten password")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Here is the password for ${user.username}, ${user.password}")

        emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)

        emailIntent.selector = emailSelectorIntent
        if (emailIntent.resolveActivity(packageManager) != null) {
            startActivity(emailIntent)
        }

    }

}