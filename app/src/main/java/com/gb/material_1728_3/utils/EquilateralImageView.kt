package com.gb.material_1728_3.utils

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.gb.material_1728_3.view.coordinator.ButtonBehavior

class EquilateralImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attributeSet,defStyleAttr), CoordinatorLayout.AttachedBehavior {


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

    override fun getBehavior(): ButtonBehavior {
        return ButtonBehavior(context)
    }
}