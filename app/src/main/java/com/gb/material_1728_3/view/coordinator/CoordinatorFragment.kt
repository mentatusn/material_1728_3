package com.gb.material_1728_3.view.coordinator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gb.material_1728_3.R



class CoordinatorFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coordinator, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =   CoordinatorFragment()
    }
}