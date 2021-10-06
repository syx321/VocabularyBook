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



}