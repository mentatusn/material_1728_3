package com.gb.material_1728_3.view.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.ActivityApiBinding
import com.gb.material_1728_3.databinding.ActivityApiBottomBinding
import com.gb.material_1728_3.databinding.FragmentSettingsBinding
import com.gb.material_1728_3.view.main.MainFragment
import com.gb.material_1728_3.view.viewpager.EarthFragment
import com.gb.material_1728_3.view.viewpager.MarsFragment
import com.gb.material_1728_3.view.viewpager.SystemFragment
import com.gb.material_1728_3.view.viewpager.ViewPagerAdapter
import com.google.android.material.badge.BadgeDrawable

class ApiBottomActivity : AppCompatActivity() {

    lateinit var binding: ActivityApiBottomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottom_view_earth->{
                    navigateTo(EarthFragment())
                    true
                }
                R.id.bottom_view_mars->{
                    navigateTo(MarsFragment())
                    true
                }
                R.id.bottom_view_system->{
                    navigateTo(SystemFragment())
                    true
                }
                else -> true
            }
        }

        binding.bottomNavigationView.selectedItemId = R.id.bottom_view_system

        val badge = binding.bottomNavigationView.getOrCreateBadge(R.id.bottom_view_mars)
        badge.number = 10000
        badge.maxCharacterCount = 4
        badge.badgeGravity = BadgeDrawable.TOP_START
        //binding.bottomNavigationView.removeBadge(R.id.bottom_view_mars)
    }

    fun navigateTo(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}