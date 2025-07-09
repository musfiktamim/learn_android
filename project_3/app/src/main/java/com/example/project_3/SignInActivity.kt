package com.example.project_3

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
    companion object{
        const val NAMEKEY = "com.example.project_3.SigninActivity.NAMEKEY"
        const val EMAILKEY = "com.example.project_3.SigninActivity.EMAILKEY"
    }
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSignIn = findViewById<Button>(R.id.btnSignIn)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val txtDontHaveAccount = findViewById<TextView>(R.id.txtDontHaveAccount)

        txtDontHaveAccount.setOnClickListener {
            intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btnSignIn.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            if (email.isNotEmpty()&&password.isNotEmpty()){
                database = FirebaseDatabase.getInstance().getReference("Contact_Users")
                database.child(email.split("@")[0]).get().addOnSuccessListener {
                    if (it.exists()){
                        val getpassword = it.child("password").value.toString()
                        if(getpassword==password){
                            val getname = it.child("name").value.toString()
                            val getemail = it.child("email").value.toString()
                            intent = Intent(applicationContext, AddContactActivity::class.java)
                            intent.putExtra(NAMEKEY,getname)
                            intent.putExtra(EMAILKEY,getemail)
                            Toast.makeText(this, "User ${getname} is Loged in", Toast.LENGTH_SHORT).show()
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this, "User not exist", Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Fill", Toast.LENGTH_SHORT).show()
            }

        }

    }
}