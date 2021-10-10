package com.example.vocabularybook.controller


import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.vocabularybook.R
import com.example.vocabularybook.controller.fregment.FirstFragment
import com.example.vocabularybook.controller.fregment.SecondFragment

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isLand()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.first_content, FirstFragment())
                .replace(R.id.second_content, SecondFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.first_content, FirstFragment())
                .commit()
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar()?.hide()
        }
    }

    fun isLand(): Boolean {
        val mConfiguration = this.resources.configuration //获取设置的配置信息

        val ori = mConfiguration.orientation //获取屏幕方向

        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            //横屏
            Log.d("isLand", "横向")
            return true
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏
            Log.d("isLand", "竖屏")
            return false
        }
        return false
    }
}