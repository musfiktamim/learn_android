package com.example.learn_16

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learn_16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var userArraForAdapter:ArrayList<User>
    lateinit var binding:ActivityMainBinding
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

        val name = arrayOf("Musfik","Tamim","Rahman")
        val lastmessage = arrayOf("Hi😁","Hello😋","What'sUp Buddy😐")
        val lastmtime = arrayOf("5:11 PM","4:1 AM","6:1 AM")
        val ImageId = arrayOf(R.drawable.im1,R.drawable.im2,R.drawable.im3)

        userArraForAdapter = ArrayList()

        for (eachIndex in name.indices){
            val user = User(name[eachIndex],lastmessage[eachIndex],ImageId[eachIndex],lastmtime[eachIndex])
            userArraForAdapter.add(user)
        }

        binding.listviews.isClickable = true

        binding.listviews.adapter = MyAdapter(this,userArraForAdapter)


    }
}