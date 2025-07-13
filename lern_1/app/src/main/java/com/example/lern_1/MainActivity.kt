package com.example.lern_1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnDownload = findViewById<Button>(R.id.btnDownload)
        val btnUpload = findViewById<Button>(R.id.btnUpload)

        btnDownload.setOnClickListener {
            Toast.makeText(this, "Downloading...", Toast.LENGTH_SHORT).show()
        }

        btnUpload.setOnClickListener {
            Toast.makeText(this, "Uploading...", Toast.LENGTH_SHORT).show()
        }


    }
}