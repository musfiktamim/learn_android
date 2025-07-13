package com.example.learn_13

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learn_13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
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
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.customdialogbackground))

        val btnSendReport = dialog.findViewById<Button>(R.id.btnReport)
        val btnGood = dialog.findViewById<Button>(R.id.btnGood)

        btnGood.setOnClickListener {
            dialog.dismiss()
        }

        btnSendReport.setOnClickListener {
            Toast.makeText(this, "Report Sended", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        binding.btOpenDialog.setOnClickListener {
            dialog.show()
        }


    }
}