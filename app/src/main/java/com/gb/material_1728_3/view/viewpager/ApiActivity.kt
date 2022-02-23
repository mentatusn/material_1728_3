package com.gb.material_1728_3.view.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.ActivityApiBinding
import com.gb.material_1728_3.databinding.FragmentSettingsBinding
import com.gb.material_1728_3.view.main.MainFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ApiActivity : AppCompatActivity() {

    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPager2Adapter(this)
       // binding.tabLayout.setupWithViewPager(binding.viewPager)
        val tabTitles = arrayOf("Earth", "Mars", "System")
        TabLayoutMediator(binding.tabLayout,binding.viewPager, object : TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = tabTitles[position]
            }
        }).attach()

        binding.tabLayout.getTabAt(EARTH)?.customView = layoutInflater.inflate(R.layout.activity_api_tablayout_item_earth,null)
        binding.tabLayout.getTabAt(MARS)?.customView = layoutInflater.inflate(R.layout.activity_api_tablayout_item_mars,null)
        binding.tabLayout.getTabAt(SYSTEM)?.customView = layoutInflater.inflate(R.layout.activity_api_tablayout_item_system,null)
    }
}