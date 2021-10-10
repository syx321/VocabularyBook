package com.example.vocabularybook.controller.fregment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.vocabularybook.R
import com.example.vocabularybook.model.MyDBOpenHelper
import com.example.vocabularybook.util.AppWords.SQL_UPDATE_DATABASE

class SecondFragment : Fragment() {
    @SuppressLint("Range", "Recycle")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_compose, container, false)
        Log.d("second_fregment", "init")
        val dbOpenHelper = MyDBOpenHelper(view.context, null, null, null)
        val db = dbOpenHelper.writableDatabase
        val intent = Intent()

        val english = intent.getStringExtra("english").toString()

        val english_TextView = view.findViewById<TextView>(R.id.show_english)
        val chinese_EditText = view.findViewById<EditText>(R.id.show_chinese)

        english_TextView.text = english
        val cursor = db.rawQuery("select Chinese from note where English = " + english, null)
        var text = ""
        while (cursor != null && cursor.moveToFirst()) {
            text += cursor.getString(cursor.getColumnIndex("Chinese"))
        }
        chinese_EditText.hint = text

        view.findViewById<Button>(R.id.btn_change).setOnClickListener(View.OnClickListener {
            db.execSQL(SQL_UPDATE_DATABASE, arrayOf(english_TextView.text, chinese_EditText.text))
        })
        return view
    }

}