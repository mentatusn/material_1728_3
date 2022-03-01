package com.gb.material_1728_3.view.animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.ActivityAnimationsBinding
import java.util.*

class AnimationsActivity : AppCompatActivity() {

    private var flag = false
    private val duration = 1000L
    lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.transparentBackground.alpha =0f
        binding.optionOneContainer.alpha =0f
        binding.optionOneContainer.isClickable=false
        binding.optionTwoContainer.isClickable=false
        binding.optionTwoContainer.alpha =0f

        binding.fab.setOnClickListener {
            flag = !flag
            if(flag){
                //ObjectAnimator.ofFloat(binding.plusImageview,"rotation",0f,405f).start()
                ObjectAnimator.ofFloat(binding.plusImageview,View.ROTATION,0f,405f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer,View.TRANSLATION_Y,0f,-130f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer,View.TRANSLATION_Y,0f,-260f).setDuration(duration).start()

                binding.optionTwoContainer.animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionTwoContainer.isClickable=true
                            super.onAnimationEnd(animation)
                        }
                    })

                binding.optionOneContainer.animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionOneContainer.isClickable=true
                            super.onAnimationEnd(animation)
                        }
                    })
                binding.transparentBackground.animate()
                    .alpha(0.8f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.transparentBackground.isClickable=true
                            super.onAnimationEnd(animation)
                        }
                    })
            }else{
                ObjectAnimator.ofFloat(binding.plusImageview,View.ROTATION,405f,0f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer,View.TRANSLATION_Y,-130f,0f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer,View.TRANSLATION_Y,-260f,0f).setDuration(duration).start()

                binding.optionTwoContainer.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionTwoContainer.isClickable=false
                            super.onAnimationEnd(animation)
                        }
                    })

                binding.optionOneContainer.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionOneContainer.isClickable=false
                            super.onAnimationEnd(animation)
                        }
                    })
                binding.transparentBackground.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.transparentBackground.isClickable=false
                            super.onAnimationEnd(animation)
                        }
                    })
            }
        }

    }


}