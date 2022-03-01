package com.gb.material_1728_3.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    private var textISVisible = false
    lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = MyAdapter()
    }

    inner class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_animations_recycler_item,parent,false))
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.itemView.setOnClickListener {
                val transitionSet = TransitionSet()
                val explode = Explode()
                val fade = Fade()
                fade.duration = 999999999999
                explode.duration = 3000
                val rect1 = Rect()
                explode.excludeTarget(it,true)
                it.getGlobalVisibleRect(rect1)
                val rect2 = Rect(it.x.toInt(),it.y.toInt(),it.x.toInt()+it.width,it.y.toInt()+it.height)
                explode.epicenterCallback = object : Transition.EpicenterCallback(){
                    override fun onGetEpicenter(transition: Transition): Rect {
                        return rect1
                    }
                }
                transitionSet.addTransition(explode)
                transitionSet.addTransition(fade)
                TransitionManager.beginDelayedTransition(binding.transitionsContainer,transitionSet)
                binding.recyclerView.adapter = null
            }
        }

        override fun getItemCount(): Int {
            return 28
        }
    }
}