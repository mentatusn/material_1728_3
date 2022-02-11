package com.gb.material_1728_3.view.chips

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.FragmentChipsBinding
import com.gb.material_1728_3.databinding.FragmentMainBinding
import com.gb.material_1728_3.view.MainActivity
import com.gb.material_1728_3.view.main.BottomNavigationDrawerFragment
import com.gb.material_1728_3.viewmodel.PictureOfTheDayData
import com.gb.material_1728_3.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip


class ChipsFragment : Fragment() {


    private var _binding: FragmentChipsBinding? = null
    val binding: FragmentChipsBinding
        get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChipsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            binding.chipGroup.findViewById<Chip>(checkedId)?.let{ it->
                Toast.makeText(requireContext(), "${it.text} ${checkedId}", Toast.LENGTH_SHORT).show()
            }
        }
        binding.chipEntry.setOnCloseIconClickListener {
            Toast.makeText(requireContext(), "chipEntry close", Toast.LENGTH_SHORT).show()
        }
    }



    companion object {
        @JvmStatic
        fun newInstance() = ChipsFragment()
    }
}