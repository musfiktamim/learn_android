package com.example.learn_17

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learn_17.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra(MainActivity.NAMEKEY)
        val phone = intent.getStringExtra(MainActivity.PHONENUMBERKEY)
        val dob = intent.getStringExtra(MainActivity.DOBKEY)
        val imageid = intent.getIntExtra(MainActivity.IMAGEKEY,R.drawable.im4)

        binding.txtName.text = binding.txtName.text.toString() + name
        binding.txtPhone.text = binding.txtPhone.text.toString() + phone
        binding.txtDob.text = binding.txtDob.text.toString() + dob
        binding.profileimage.setImageResource(imageid)

    }
}