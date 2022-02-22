package com.gb.material_1728_3.view.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.ActivityApiBinding
import com.gb.material_1728_3.databinding.FragmentSettingsBinding
import com.gb.material_1728_3.view.main.MainFragment

class ApiActivity : AppCompatActivity() {

    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager) // TODO передать child
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.tabLayout.getTabAt(EARTH)?.setIcon(R.drawable.ic_earth)
        binding.tabLayout.getTabAt(MARS)?.setIcon(R.drawable.ic_mars)
        binding.tabLayout.getTabAt(SYSTEM)?.setIcon(R.drawable.ic_system)
    }
}