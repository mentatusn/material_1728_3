package com.gb.material_1728_3.view.animations

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

class AnimationsActivity : AppCompatActivity() {

    private var flag = false
    lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles:MutableList<String> = ArrayList()

        repeat(5){
            titles.add("Item ${it}")
        }
        binding.button.setOnClickListener {
            flag = !flag
            titles.shuffle()
            TransitionManager.beginDelayedTransition(binding.transitionsContainer,ChangeBounds())
            binding.transitionsContainer.removeAllViews()

            titles.forEach {
                binding.transitionsContainer.addView(TextView(this).apply {
                    text = it
                    textSize = 20f
                    transitionName = it
                    gravity = Gravity.CENTER_HORIZONTAL
                })
            }
        }

    }


}