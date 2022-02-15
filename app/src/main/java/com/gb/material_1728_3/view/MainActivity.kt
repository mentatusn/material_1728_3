package com.gb.material_1728_3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gb.material_1728_3.R
import com.gb.material_1728_3.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyThemeBlue)
        setContentView(R.layout.activity_main)


        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment.newInstance()).commit()
        }

//        recreate()
    }
}