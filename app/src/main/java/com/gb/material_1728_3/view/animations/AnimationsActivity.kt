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
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.ActivityAnimationsBinding
import com.gb.material_1728_3.databinding.ActivityAnimationsBonusStartBinding
import java.util.*

class AnimationsActivity : AppCompatActivity() {

    private var flag = true
    private val duration = 1000L
    private val mTension = 10f
    lateinit var binding: ActivityAnimationsBonusStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBonusStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backgroundImage.setOnClickListener{
            flag = !flag
            if(flag){
                val constraintSet = ConstraintSet()
                constraintSet.clone(this,R.layout.activity_animations_bonus_start)
                val changeBounds = ChangeBounds()
                changeBounds.duration = duration
                changeBounds.interpolator = AnticipateOvershootInterpolator(mTension)
                TransitionManager.beginDelayedTransition(binding.constraintContainer,changeBounds)
                constraintSet.applyTo(binding.constraintContainer)
            }else{
                val constraintSet = ConstraintSet()
                constraintSet.clone(this,R.layout.activity_animations_bonus_end)
                /*constraintSet.connect(R.id.title,ConstraintSet.END,R.id.constraint_container,ConstraintSet.END)
                constraintSet.connect(R.id.title,ConstraintSet.START,R.id.constraint_container,ConstraintSet.START)
                constraintSet.connect(R.id.title,ConstraintSet.TOP,R.id.constraint_container,ConstraintSet.TOP)*/

                val changeBounds = ChangeBounds()
                changeBounds.duration = duration
                changeBounds.interpolator = AnticipateOvershootInterpolator(mTension)
                TransitionManager.beginDelayedTransition(binding.constraintContainer,changeBounds)
                constraintSet.applyTo(binding.constraintContainer)
            }

        }


    }


}