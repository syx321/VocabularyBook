package com.example.vocabularybook.controller

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vocabularybook.R
import com.example.vocabularybook.util.MyDBOpenHelper
import com.example.vocabularybook.util.AppWords

class ShowNote : AppCompatActivity() {
    lateinit var dbOpenHelper: MyDBOpenHelper
    lateinit var db: SQLiteDatabase

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_page)

        dbOpenHelper = MyDBOpenHelper(this, null, null, null)
        db = dbOpenHelper.writableDatabase
        val intent = getIntent()

        val english = intent.getStringExtra("english").toString()

        val english_TextView = this.findViewById<TextView>(R.id.show_english)
        val chinese_EditText = this.findViewById<EditText>(R.id.show_chinese)

        english_TextView.text = english
        val cursor = db.rawQuery("select Chinese from note where English = '" + english + "'", null)
        var text = ""
        while (cursor != null && cursor.moveToFirst()) {
            text += cursor.getString(cursor.getColumnIndex("Chinese"))
        }
        chinese_EditText.hint = text

        this.findViewById<Button>(R.id.btn_change).setOnClickListener(View.OnClickListener {
            db.execSQL(AppWords.SQL_UPDATE_DATABASE, arrayOf(english_TextView.text, chinese_EditText.text))
        })
    }
}