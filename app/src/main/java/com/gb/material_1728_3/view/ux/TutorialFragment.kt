package com.gb.material_1728_3.view.ux

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.gb.material_1728_3.databinding.FragmentUxButtonBinding
import smartdevelop.ir.eram.showcaseviewlib.GuideView
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity


class TutorialFragment : Fragment() {

    private var _binding: FragmentUxButtonBinding? = null
    val binding: FragmentUxButtonBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUxButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBad()
    }

    private fun showBad(){
        val builder = GuideView.Builder(requireContext())
            .setTitle("Это неправильно")
            .setContentText("Мы не работаем с цветами и размерами")
            .setGravity(Gravity.auto)
            .setDismissType(DismissType.anywhere)
            .setTargetView(binding.layoutBad)
            .setGuideListener {
                // тут запустим сразу вторую подсказку
                showGood()
            }
        builder.build().show()
    }
    private fun showGood(){
        val builder = GuideView.Builder(requireContext())
            .setTitle("Это правильно")
            .setContentText("Мы работаем с прозначностью")
            .setGravity(Gravity.center)
            .setDismissType(DismissType.anywhere)
            .setTargetView(binding.layoutGood)
        builder.build().show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = TutorialFragment()
    }
}