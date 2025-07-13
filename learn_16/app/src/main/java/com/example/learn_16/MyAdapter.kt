package com.example.learn_16

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(val context:Activity,val arrayList: ArrayList<User>):ArrayAdapter<User>(context,R.layout.custom_list_view_item,arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.custom_list_view_item,null)
        val name = view.findViewById<TextView>(R.id.name)
        val lastMessage = view.findViewById<TextView>(R.id.lastMessage)
        val lastTimeM = view.findViewById<TextView>(R.id.lastm)
        val imageView = view.findViewById<CircleImageView>(R.id.profile_image)

        name.text = arrayList[position].name
        lastMessage.text = arrayList[position].lastmessage
        lastTimeM.text = arrayList[position].LastTime
        imageView.setImageResource(arrayList[position].imgId)

        return view
    }
}