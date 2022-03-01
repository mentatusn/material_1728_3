package com.gb.material_1728_3.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
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

        binding.button.setOnClickListener {
            flag = !flag

            val changeBounds = ChangeBounds()
            changeBounds.setPathMotion(ArcMotion())
            changeBounds.duration = 3000

            TransitionManager.beginDelayedTransition(binding.transitionsContainer, changeBounds)
            val params = binding.button.layoutParams as FrameLayout.LayoutParams
            params.gravity =if (flag) {
                 Gravity.BOTTOM or Gravity.END
            } else {
                Gravity.TOP or Gravity.START
            }
            binding.button.layoutParams = params
        }

    }


}