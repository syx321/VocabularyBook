package com.example.vocabularybook.controller


import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vocabularybook.R
import com.example.vocabularybook.controller.fregment.first_fragment
import com.example.vocabularybook.controller.fregment.second_fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isLand()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.first_content, first_fragment())
                .replace(R.id.second_content, second_fragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.second_content, second_fragment())
                .commit()
        }
    }

    private fun isLand(): Boolean {
        return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }
}