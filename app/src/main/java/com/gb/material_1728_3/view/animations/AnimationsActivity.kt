package com.gb.material_1728_3.view.animations

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.*
import com.gb.material_1728_3.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    private var textISVisible = false
    lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {

            val transitionSet = TransitionSet()
            val slide = Slide(Gravity.END)
            val explode = Explode()
            slide.duration = 2000
            transitionSet.ordering = TransitionSet.ORDERING_SEQUENTIAL
            transitionSet.addTransition(slide)
            //transitionSet.addTransition(explode)
            TransitionManager.beginDelayedTransition(binding.transitionsContainer,transitionSet)

            textISVisible = !textISVisible
            binding.text.visibility = if (textISVisible) View.VISIBLE else View.GONE

        }
    }
}