package com.example.learn_10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.values

class SignUpActivity : AppCompatActivity() {

    lateinit var databse: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtEmail = findViewById<EditText>(R.id.txtMail)
        val txtName = findViewById<EditText>(R.id.txtName)
        val txtPass = findViewById<EditText>(R.id.txtPassword)
        val txtUniqueId = findViewById<EditText>(R.id.txtUniqueId)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val txtDonetHaveAccount = findViewById<TextView>(R.id.txtDontHaveaccount)

        btnSignUp.setOnClickListener {
            val name = txtName.text.toString()
            val email = txtEmail.text.toString()
            val password = txtPass.text.toString()
            val uniqueId = txtUniqueId.text.toString()
            if(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && uniqueId.isNotEmpty()){
                val user = User(name = name,email=email,password=password,uniqueId=uniqueId)
                databse = FirebaseDatabase.getInstance().getReference("Users")
                databse.child(uniqueId).setValue(user).addOnSuccessListener {
                    Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Some thing went wrong", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Please fill the all fields", Toast.LENGTH_SHORT).show()
            }
        }

        txtDonetHaveAccount.setOnClickListener {
            finish()
        }

    }
}