package com.example.learn_15

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learn_15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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

        val taskList = arrayListOf<String>()
        taskList.add("Attened1")
        taskList.add("Attened2")
        taskList.add("Attened3")
        taskList.add("Attened4")
        taskList.add("Attened5")
        taskList.add("Attened6")
        taskList.add("Attened7")


        val adapterForListView = ArrayAdapter(this,android.R.layout.simple_list_item_1,taskList)

        binding.listviews.adapter = adapterForListView

        binding.listviews.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${(view as TextView).text} clicked", Toast.LENGTH_SHORT).show()
        }

    }
}