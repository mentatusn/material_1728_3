package com.gb.material_1728_3.view.ux

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.*
import android.text.style.*
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.provider.FontRequest
import androidx.core.provider.FontsContractCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.FragmentMainBinding
import com.gb.material_1728_3.databinding.FragmentUxTextBinding
import com.gb.material_1728_3.view.MainActivity
import com.gb.material_1728_3.view.main.BottomNavigationDrawerFragment
import com.gb.material_1728_3.view.settings.SettingsFragment
import com.gb.material_1728_3.viewmodel.PictureOfTheDayData
import com.gb.material_1728_3.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior


class TextFragment : Fragment() {

    private var _binding: FragmentUxTextBinding? = null
    val binding: FragmentUxTextBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUxTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    companion object {
        @JvmStatic
        fun newInstance() = TextFragment()
    }
}