package com.example.learn_10

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DataShowingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_showing)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtShow = findViewById<TextView>(R.id.txtViewWelcome)
        val name = intent.getStringExtra(SignInActivity.NAMEKEY)
        val email = intent.getStringExtra(SignInActivity.EMAILKEY)
        val password = intent.getStringExtra(SignInActivity.PASSWORDKEY)
        val uniqueId = intent.getStringExtra(SignInActivity.UNIQUEIDKEY)

        val showTxtString = "Name:- ${name}\nEmail:- ${email}\nPassword:- ${password}\nUniqueId:- ${uniqueId}"

        txtShow.text = showTxtString

    }
}