package com.example.learn_17

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context:Activity,private val arraylist:ArrayList<User>):ArrayAdapter<User>(context,R.layout.list_view_item,arraylist){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_view_item,null)

        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtMessage = view.findViewById<TextView>(R.id.txtLastM)
        val txtLastTime = view.findViewById<TextView>(R.id.txtTime)
        val imageview = view.findViewById<ImageView>(R.id.accountpicture)

        txtName.text = arraylist[position].name
        txtMessage.text = arraylist[position].lastmessage
        txtLastTime.text = arraylist[position].lasttime
        imageview.setImageResource(arraylist[position].imageid)

        return view
    }
}