package com.gb.material_1728_3.view.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.BottomNavigationLayoutBinding
import com.gb.material_1728_3.databinding.FragmentMainBinding
import com.gb.material_1728_3.view.animations.AnimationsActivity
import com.gb.material_1728_3.view.bottomnavigation.ApiBottomActivity
import com.gb.material_1728_3.view.recycler.RecyclerActivity
import com.gb.material_1728_3.view.viewpager.ApiActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomNavigationDrawerFragment:BottomSheetDialogFragment() {

    private var _binding: BottomNavigationLayoutBinding? = null
    val binding: BottomNavigationLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomNavigationLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigationView.setNavigationItemSelectedListener { menu->
            when(menu.itemId){
                R.id.navigation_one -> {
                    startActivity(Intent(requireContext(),ApiActivity::class.java))
                }
                R.id.navigation_two -> {
                    startActivity(Intent(requireContext(), ApiBottomActivity::class.java))
                }
                R.id.navigation_three -> {
                    startActivity(Intent(requireContext(), AnimationsActivity::class.java))
                }
                R.id.navigation_four -> {
                    startActivity(Intent(requireContext(), RecyclerActivity::class.java))
                }
            }
            dismiss()
            true
        }
    }
}