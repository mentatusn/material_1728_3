package com.gb.material_1728_3.view.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.FragmentMainBinding
import com.gb.material_1728_3.viewmodel.PictureOfTheDayData
import com.gb.material_1728_3.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior


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

     lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, Observer {
            renderData(it)
        })
        viewModel.sendRequest()

        binding.inputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data  = Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            })
        }

        bottomSheetBehavior= BottomSheetBehavior.from(binding.included.bottomSheetContainer)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED


        bottomSheetBehavior.addBottomSheetCallback( object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState){
                    /*BottomSheetBehavior.STATE_DRAGGING -> TODO("not implemented")
                    BottomSheetBehavior.STATE_COLLAPSED -> TODO("not implemented")
                    BottomSheetBehavior.STATE_EXPANDED -> TODO("not implemented")
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> TODO("not implemented")
                    BottomSheetBehavior.STATE_HIDDEN -> TODO("not implemented")
                    BottomSheetBehavior.STATE_SETTLING -> TODO("not implemented")*/
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("mylogs", "slideOffset $slideOffset")
            }

        })
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