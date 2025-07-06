package com.example.lern_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lern_3.RelativeActivity

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

        val btnLinearLayout = findViewById<Button>(R.id.btnLinearLayout)
        val btnRelativeLayout = findViewById<Button>(R.id.btnRelativeLayout)
        val btnConstantLayout = findViewById<Button>(R.id.btnConstantLayout)

        btnRelativeLayout.setOnClickListener {
            intent = Intent(this, RelativeActivity::class.java)
            startActivity(intent)
        }
        btnLinearLayout.setOnClickListener {
            intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
        btnConstantLayout.setOnClickListener {
            intent = Intent(this, ConstantLayoutActivity::class.java)
            startActivity(intent)
        }

    }
}