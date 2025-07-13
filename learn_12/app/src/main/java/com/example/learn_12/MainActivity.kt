package com.example.learn_12

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learn_12.databinding.ActivityMainBinding

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

        binding.btnNormalAlert.setOnClickListener {
            val alertBuilder = AlertDialog.Builder(this)
            alertBuilder.setIcon(R.drawable.ic_launcher_background)
            alertBuilder.setTitle("Are You SURE?")
            alertBuilder.setMessage("Are You Want Quit")
            alertBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener{`interface`, i ->
                finish()
            })
            alertBuilder.setNegativeButton("No", DialogInterface.OnClickListener{`interface`,i->
                `interface`.dismiss()
            })
            alertBuilder.show()
        }

        binding.btnRedioAlert.setOnClickListener {
            val options = arrayOf("Hello","World")
            val alertBuilder1 = AlertDialog.Builder(this)
            alertBuilder1.setTitle("Choice")
            alertBuilder1.setSingleChoiceItems(options,0,DialogInterface.OnClickListener{`interface`, i ->
                Toast.makeText(this, "Clicked ${options[i]}", Toast.LENGTH_SHORT).show()
            })
            alertBuilder1.setPositiveButton("Yes", DialogInterface.OnClickListener{`interface`, i ->
                `interface`.dismiss()
            })
            alertBuilder1.setNegativeButton("No", DialogInterface.OnClickListener{`interface`, i ->
                `interface`.dismiss()
            })
            alertBuilder1.show()

        }

        binding.btnCheckBoxAlert.setOnClickListener {
            val options = arrayOf("Hello" ,"" +
                    "World")
            val alertBuilder = AlertDialog.Builder(this)
            alertBuilder.setTitle("Checked")
            alertBuilder.setMultiChoiceItems(options,null, DialogInterface.OnMultiChoiceClickListener{`interface`, i, bool ->
                if(bool){
                    Toast.makeText(this, "Secelected ${options[i]}", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Dis_Secelected ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            })
            alertBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener{`interface`, i ->
                `interface`.dismiss()
            })
            alertBuilder.setNegativeButton("No", DialogInterface.OnClickListener{`interface`, i ->
                `interface`.dismiss()
            })

            alertBuilder.show()

        }

    }
}