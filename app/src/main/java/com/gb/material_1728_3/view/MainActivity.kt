package com.gb.material_1728_3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import com.gb.material_1728_3.R
import com.gb.material_1728_3.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // SP
        setTheme(R.style.MyBlackBlue)
        setContentView(R.layout.activity_main)

        val textView = TextView(this).apply {
            text=""
            textSize=30f
            gravity = Gravity.NO_GRAVITY

        }

        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment.newInstance()).commit()
        }

//        recreate()
    }
}