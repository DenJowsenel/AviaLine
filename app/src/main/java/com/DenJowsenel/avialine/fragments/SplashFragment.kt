package com.DenJowsenel.avialine.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.DenJowsenel.avialine.MainActivity
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    companion object{
        fun newInstance() = SplashFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSplashBinding.bind(view)
        binding.name.setOnClickListener{
            (activity as MainActivity).navigateToFragment(CompaniesFragment.newInstance())
        }
    }
}