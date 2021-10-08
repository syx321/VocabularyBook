package com.example.vocabularybook.controller.fregment

import android.annotation.SuppressLint
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabularybook.R
import com.example.vocabularybook.controller.MyAdapter
import com.example.vocabularybook.model.MyDBOpenHelper
import com.example.vocabularybook.model.listItem

import com.example.vocabularybook.util.AppWords.*

class first_fragment : Fragment() {
    private val itemList = ArrayList<listItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_notelist,container,false)
        Log.d("first_fregment","init")
        return view
    }

    override fun onStart() {
        super.onStart()
        initItem()
        val myAdapter = MyAdapter(itemList)
        val listview = view!!.findViewById<RecyclerView>(R.id.main_list)
        listview.layoutManager = LinearLayoutManager(this.context)
        listview.adapter = myAdapter
    }



    @SuppressLint("Recycle", "Range")
    fun initItem() {
        val dbOpenHelper = MyDBOpenHelper(this.context,null,null,null)
        val db: SQLiteDatabase = dbOpenHelper.writableDatabase
        val cursor: Cursor = db.rawQuery(SQL_SELECT_ALL,null)
//        db.execSQL("insert into note values(?,?,?)", arrayOf("three","3","2021/10/7"))

        //TODO problem
        while (cursor.moveToNext()) {
            val listItem = listItem(cursor.getString(cursor.getColumnIndex("English")),
                cursor.getString(cursor.getColumnIndex("time")))
            itemList.add(listItem)
            Log.d("listItem",listItem.english+" "+listItem.time)
        }
//        val listItem = listItem("English", "2021/10/6")
//        itemList.add(listItem)

    }
}