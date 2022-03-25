package com.gb.material_1728_3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import com.gb.material_1728_3.R
import com.gb.material_1728_3.view.coordinator.CoordinatorFragment
import com.gb.material_1728_3.view.main.MainFragment


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyThemeGreen)
        setContentView(R.layout.activity_splash)


        findViewById<ImageView>(R.id.image_view).animate().rotationBy(720f)
            .setInterpolator(LinearInterpolator()).duration = 10000L


        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 2000L)

    }
}