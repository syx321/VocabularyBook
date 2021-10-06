package com.example.vocabularybook.controller


import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
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
                .replace(R.id.first_content, first_fragment())
                .commit()
        }
    }

    private fun isLand(): Boolean {
        val mConfiguration = this.resources.configuration //获取设置的配置信息

        val ori = mConfiguration.orientation //获取屏幕方向

        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            //横屏
            Log.d("isLand","横向")
            return true
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏
            Log.d("isLand","竖屏")
            return false
        }
        return false
    }
}