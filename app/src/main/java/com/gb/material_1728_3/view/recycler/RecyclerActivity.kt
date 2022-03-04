package com.gb.material_1728_3.view.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gb.material_1728_3.R
import com.gb.material_1728_3.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = arrayListOf(
            Data("Earth",type = TYPE_EARTH),
            Data("Earth",type = TYPE_EARTH),
            Data("Mars", "",type = TYPE_MARS),
            Data("Earth",type = TYPE_EARTH),
            Data("Earth",type = TYPE_EARTH),
            Data("Earth",type = TYPE_EARTH),
            Data("Mars", "",type = TYPE_MARS)
        )

        binding.recyclerView.adapter =RecyclerActivityAdapter({
             Toast.makeText(this@RecyclerActivity,it.someText,Toast.LENGTH_SHORT).show()
        },data)
    }
}