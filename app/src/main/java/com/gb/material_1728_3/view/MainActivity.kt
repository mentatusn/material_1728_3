package com.gb.material_1728_3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import com.gb.material_1728_3.R
import com.gb.material_1728_3.view.coordinator.CoordinatorFragment
import com.gb.material_1728_3.view.main.MainFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyThemeGreen)
        setContentView(R.layout.activity_main)


        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment.newInstance()).commit()
            //supportFragmentManager.beginTransaction().replace(R.id.container,CoordinatorFragment.newInstance()).commit()
        }

    }
}