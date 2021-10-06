package com.example.vocabularybook.controller

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.vocabularybook.R
import com.example.vocabularybook.model.listItem

class MyAdapter(activity: Activity, val resourceId: Int, data: List<listItem>) :
    ArrayAdapter<listItem>(activity, resourceId, data) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
        val english = view.findViewById<TextView>(R.id.item_content)
        val time = view.findViewById<TextView>(R.id.item_time)

        val item = getItem(position)
        if (item != null) {
            english.text = item.english
            time.text = item.time
        }
        return view
    }

}