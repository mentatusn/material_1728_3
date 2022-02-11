package com.gb.material_1728_3.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.FragmentMainBinding
import com.gb.material_1728_3.viewmodel.PictureOfTheDayData
import com.gb.material_1728_3.viewmodel.PictureOfTheDayViewModel


class MainFragment : Fragment() {


    private var _binding: FragmentMainBinding? = null
    val binding: FragmentMainBinding
        get() = _binding!!

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, Observer {
            renderData(it)
        })
        viewModel.sendRequest()
    }

    private fun renderData(pictureOfTheDayData: PictureOfTheDayData) {
        when (pictureOfTheDayData) {
            is PictureOfTheDayData.Error -> {

            }
            is PictureOfTheDayData.Loading -> {

            }
            is PictureOfTheDayData.Success -> {
                binding.imageView.load(pictureOfTheDayData.serverResponse.url){
                    placeholder(R.drawable.ic_no_photo_vector)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}