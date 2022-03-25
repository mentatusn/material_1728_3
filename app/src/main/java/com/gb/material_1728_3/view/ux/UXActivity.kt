package com.gb.material_1728_3.view.ux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.ActivityUxBinding
import com.gb.material_1728_3.view.coordinator.CoordinatorFragment
import com.gb.material_1728_3.view.main.MainFragment


class UXActivity : AppCompatActivity() {
    lateinit var binding: ActivityUxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationViewUX.setOnItemSelectedListener {
            when(it.itemId){
                R.id.fragment_ux_text->{
                    navigateTo(TextFragment())
                    true
                }
                else -> true
            }
        }
        binding.bottomNavigationViewUX.selectedItemId = R.id.fragment_ux_text
    }

    fun navigateTo(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }

}