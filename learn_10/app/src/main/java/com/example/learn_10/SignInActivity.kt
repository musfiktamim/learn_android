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

class SignInActivity : AppCompatActivity() {
    companion object {
        val NAMEKEY = "com.example.learn_10.SignInActivity.NAMEKEY"
        val EMAILKEY = "com.example.learn_10.SignInActivity.EMAILKEY"
        val PASSWORDKEY = "com.example.learn_10.SignInActivity.PASSWORDKEY"
        val UNIQUEIDKEY = "com.example.learn_10.SignInActivity.UNIQUEIDKEY"
    }
    lateinit var databse: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtUniqueCode = findViewById<EditText>(R.id.edtUniqueId)
        val txtHaveAccount = findViewById<TextView>(R.id.txtHaveaccount)
        val btnSignIn = findViewById<Button>(R.id.btnSignIn)

        btnSignIn.setOnClickListener {
            val uniqueCode = txtUniqueCode.text.toString()
            databse = FirebaseDatabase.getInstance().getReference("Users")
            if(uniqueCode.isNotEmpty()){
                readData(uniqueCode)
            }else{
                Toast.makeText(this, "Please Enter unique Code", Toast.LENGTH_SHORT).show()
            }
        }

        txtHaveAccount.setOnClickListener {
            intent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

    private fun readData(uniqueCode: String){
        databse = FirebaseDatabase.getInstance().getReference("Users")

        databse.child(uniqueCode).get().addOnSuccessListener {
            if(it.exists()){
                val name = it.child("name").value.toString()
                val email = it.child("email").value.toString()
                val password = it.child("password").value.toString()
                val uniqueCodeF = it.child("uniqueId").value.toString()

                intent = Intent(applicationContext, DataShowingActivity::class.java)
                intent.putExtra(NAMEKEY,name)
                intent.putExtra(EMAILKEY,email)
                intent.putExtra(PASSWORDKEY,password)
                intent.putExtra(UNIQUEIDKEY,uniqueCodeF)

                startActivity(intent)
            }else{
                Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Field", Toast.LENGTH_SHORT).show()
        }

    }


}