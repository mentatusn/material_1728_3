package com.gb.material_1728_3.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

        binding.imageView.setOnClickListener {
            flag = !flag

            val changeBounds = ChangeBounds()
            val changeImageTransform = ChangeImageTransform()
            changeBounds.duration = 3000
            changeImageTransform.duration = 3000
            TransitionManager.beginDelayedTransition(binding.transitionsContainer, changeImageTransform)
            if (flag) {
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            } else {
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }

        }

    }


}