package com.example.vocabularybook.controller

import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabularybook.R
import com.example.vocabularybook.model.listItem

class MyAdapter(val itemList: ArrayList<listItem>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val listItem = itemList.get(position)
        holder.english.text = listItem.english
        holder.time.text = listItem.time

        holder.itemView.setOnClickListener(View.OnClickListener {
            Log.d("onClick", position.toString())
        })
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var english: TextView
        var time: TextView

        init {
            english = itemView.findViewById(R.id.item_content)
            time = itemView.findViewById(R.id.item_time)
        }
    }

}
