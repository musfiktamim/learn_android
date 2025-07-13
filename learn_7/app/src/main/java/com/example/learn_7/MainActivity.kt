package com.example.learn_7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY =  "com.example.learn_7.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edt1 = findViewById<EditText>(R.id.edt1)
        val edt2 = findViewById<EditText>(R.id.edt2)
        val edt3 = findViewById<EditText>(R.id.edt3)
        val edt4 = findViewById<EditText>(R.id.edt4)

        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            val sendText = "${edt1.text.toString()} \n${edt2.text.toString()} \n${edt3.text.toString()} \n${edt4.text.toString()}"
            intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra(KEY,sendText)
            startActivity(intent)
        }


    }
}