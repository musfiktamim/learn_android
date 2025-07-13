package com.example.learn_5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
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

        val btnSecondScreen = findViewById<Button>(R.id.btnScreen)
        val btnDial = findViewById<Button>(R.id.btnDial)
        val btnWebSite = findViewById<Button>(R.id.btnMyWebSite)
        val btnCamera= findViewById<Button>(R.id.btnCamera)


        btnSecondScreen.setOnClickListener {
            intent = Intent(this, SecondScreenActivity::class.java)
            startActivity(intent)
        }
        btnDial.setOnClickListener {
            intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01855241666"))
            startActivity(intent)
        }
        btnWebSite.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://musfiktamim2.vercel.app"))
            startActivity(intent)
        }
        btnCamera.setOnClickListener {
            intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

    }
}