package com.example.tablayout

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Get data from SharedPreferences
        val username = sharedPreferences.getString("username", "N/A")
        val email = sharedPreferences.getString("email", "N/A")
        val phone = sharedPreferences.getString("phone", "N/A")

        // Find Views by ID
        val usernameTextView = findViewById<TextView>(R.id.usernameTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val phoneTextView = findViewById<TextView>(R.id.phoneTextView)

        // Set text to views
        usernameTextView.text = "Username: $username"
        emailTextView.text = "Email: $email"
        phoneTextView.text = "Phone: $phone"

        val logoutButton = findViewById<Button>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish() // Optionally finish ThirdActivity if you want to remove it from the back stack
        }
    }
}
