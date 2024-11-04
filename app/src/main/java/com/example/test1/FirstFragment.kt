package com.example.test1

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator
import androidx.fragment.app.Fragment
import com.example.test1.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        animateImage()
    }

    private fun animateImage() {
        val fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        val translate = AnimationUtils.loadAnimation(context, R.anim.translate_up_down)

        val animationSet = AnimationSet(true).apply {
            interpolator = AccelerateDecelerateInterpolator()
            addAnimation(fadeIn)
            addAnimation(translate)
            duration = 1000
            fillAfter = true
        }

        binding.imageView.startAnimation(animationSet)
    }
}

