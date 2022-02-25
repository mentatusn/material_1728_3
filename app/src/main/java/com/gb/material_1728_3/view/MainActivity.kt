package com.gb.material_1728_3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import com.gb.material_1728_3.R
import com.gb.material_1728_3.view.main.MainFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // SP
        setTheme(R.style.MyBlackBlue)
        setContentView(R.layout.activity_test_layout)

        val textView = TextView(this).apply {
            text=""
            textSize=30f
            gravity = Gravity.NO_GRAVITY

        }

        if(savedInstanceState==null){
            //supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment.newInstance()).commit()
        }

        /*findViewById<Button>(R.id.button1).visibility = View.GONE
        findViewById<Button>(R.id.button2).visibility = View.GONE*/

        //findViewById<Group>(R.id.group1).visibility = View.GONE

//        recreate()
    }
}