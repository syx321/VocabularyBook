package com.example.vocabularybook.controller

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vocabularybook.R
import com.example.vocabularybook.model.MyDBOpenHelper
import com.example.vocabularybook.util.AppWords.*
import java.util.*

class AddNewNote : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_window)

        val dbOpenHelper = MyDBOpenHelper(this, null, null, null)
        val db= dbOpenHelper.writableDatabase


        //设置确认的点击事件
        this.findViewById<TextView>(R.id.btn_add).setOnClickListener {
            val english = this.findViewById<EditText>(R.id.add_confirm_english).text
            val chinese = this.findViewById<EditText>(R.id.add_confirm_chinese).text
            val calendar = Calendar.getInstance()
            val date: String = calendar.get(Calendar.YEAR).toString() +
                    "/" +
                    (calendar.get(Calendar.MONTH) + 1) + "/" +
                    calendar.get(Calendar.DATE)

            db.execSQL(SQL_INSERT_DATABASE, arrayOf(english, chinese,date))
            finish()
        }
    }
}

