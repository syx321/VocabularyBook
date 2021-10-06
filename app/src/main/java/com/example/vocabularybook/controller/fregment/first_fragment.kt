package com.example.vocabularybook.controller.fregment

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.vocabularybook.R
import com.example.vocabularybook.model.MyDBOpenHelper
import com.example.vocabularybook.model.listItem

class first_fragment : Fragment() {
    private val itemList = ArrayList<listItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.fragment_notelist,container,false)
        Log.d("first_fregment","init")


        return view
    }

    fun initItem() {
        val dbOpenHelper = MyDBOpenHelper(this.context,null,null,null)
        val db: SQLiteDatabase = dbOpenHelper.readableDatabase

    }
}