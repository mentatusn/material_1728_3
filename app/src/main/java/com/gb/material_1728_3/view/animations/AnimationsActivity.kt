package com.gb.material_1728_3.view.animations

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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
            val fade = Fade()
            val changeBounds = ChangeBounds()
            fade.duration = 2000
            changeBounds.duration= 5000
            transitionSet.ordering = TransitionSet.ORDERING_SEQUENTIAL
            transitionSet.addTransition(fade)
            transitionSet.addTransition(changeBounds)
            TransitionManager.beginDelayedTransition(binding.transitionsContainer,transitionSet)

            textISVisible = !textISVisible
            binding.text.visibility = if (textISVisible) View.VISIBLE else View.GONE

        }
    }
}