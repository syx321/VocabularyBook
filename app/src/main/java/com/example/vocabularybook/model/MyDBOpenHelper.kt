package com.example.vocabularybook.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.vocabularybook.util.AppWords

class MyDBOpenHelper : SQLiteOpenHelper {

    constructor(context: Context?, name: String?, factory: CursorFactory?, version: Int) :
            super(
                context,
                "my.db",
                null,
                1
            )


    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(AppWords.SQL_CREATE_DATABASE)
        Log.d("MyDBOpenHelper", "onCreate")
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, i: Int, i1: Int) {
        /*不会涉及数据库版本升级*/
    }
}