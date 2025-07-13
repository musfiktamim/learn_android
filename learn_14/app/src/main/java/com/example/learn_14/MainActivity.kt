package com.example.learn_14

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learn_14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var currentIndex = 0
    lateinit var image:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnprev.setOnClickListener{
            var imageInt = this.resources.getIdentifier("pic$currentIndex","id",packageName)
            image = findViewById(imageInt)
            image.alpha = 0f

            currentIndex = (currentIndex-1)%4

            val imageIntShow = this.resources.getIdentifier("pic$currentIndex","id",packageName)
            image = findViewById(imageIntShow)
            image.alpha = 1f
        }
        binding.btnnext.setOnClickListener{
            var imageInt = this.resources.getIdentifier("pic$currentIndex","id",packageName)
            image = findViewById(imageInt)
            image.alpha = 0f

            currentIndex = (currentIndex+1)%4

            val imageIntShow = this.resources.getIdentifier("pic$currentIndex","id",packageName)
            image = findViewById(imageIntShow)
            image.alpha = 1f
        }


    }
}