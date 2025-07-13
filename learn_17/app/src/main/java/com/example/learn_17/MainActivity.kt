package com.example.learn_17

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learn_17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val NAMEKEY = "com.example.learn_17.MAINACTIVITY.NAMEKEY"
        const val LASTMESSAGEKEY = "com.example.learn_17.MAINACTIVITY.LASTMESSAGEKEY"
        const val LASTTIMEKEY = "com.example.learn_17.MAINACTIVITY.LASTTIMEKEY"
        const val IMAGEKEY = "com.example.learn_17.MAINACTIVITY.IMAGEKEY"
        const val PHONENUMBERKEY = "com.example.learn_17.MAINACTIVITY.PHONENUMBERKEY"
        const val DOBKEY = "com.example.learn_17.MAINACTIVITY.DOBKEY"
    }

    lateinit var binding: ActivityMainBinding
    lateinit var listarray:ArrayList<User>
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

        //val name:String,val lastmessage:String,val lasttime:String,val imageid:Int,val phonenumber:String,val dob:String

        val arrayName = arrayOf("Muhammad","Musfiqur","Rahman","Tamim")
        val arrayLastMessage = arrayOf("hey😳","Hello☺","What'sup😏","Reply?😪")
        val arrayLastTime = arrayOf("10:10AM","12:12PM","7:8PM","10:00PM")
        val arrayImageId = arrayOf(R.drawable.im1,R.drawable.im2,R.drawable.im3,R.drawable.im4)
        val arrayPhonNumber = arrayOf("01855241666","01855241665","01855241664","01855241663")
        val arrayDOB = arrayOf("9-10-2018","9-11-2019","9-11-2020","9-11-2021")

        listarray = ArrayList()

        for (i in arrayName.indices){
            val user = User(name = arrayName[i], lastmessage = arrayLastMessage[i], lasttime = arrayLastTime[i], imageid = arrayImageId[i], phonenumber = arrayPhonNumber[i], dob = arrayDOB[i])
            listarray.add(user)
        }

        binding.listview.adapter = MyAdapter(this,listarray)

        binding.listview.setOnItemClickListener { parent, view, position, id ->
            intent = Intent(applicationContext,UserActivity::class.java)


            intent.putExtra(NAMEKEY,listarray[position].name)
            intent.putExtra(LASTMESSAGEKEY,listarray[position].lastmessage)
            intent.putExtra(LASTTIMEKEY, listarray[position].lasttime)
            intent.putExtra(DOBKEY, listarray[position].dob)
            intent.putExtra(PHONENUMBERKEY,listarray[position].phonenumber)
            intent.putExtra(IMAGEKEY,listarray[position].imageid)

            startActivity(intent)
        }


    }
}