package com.example.lern_2

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLight = findViewById<Button>(R.id.btnLight)
        val btnDark = findViewById<Button>(R.id.btnDark)
        val mainLayout = findViewById<LinearLayout>(R.id.mainLayout)

        btnLight.setOnClickListener {
            mainLayout.setBackgroundResource(R.color.white)
        }
        btnDark.setOnClickListener {
            mainLayout.setBackgroundResource(R.color.black)
        }

    }
}