package com.DenJowsenel.avialine.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.DenJowsenel.avialine.presentation.MainActivity
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    companion object{
        fun newInstance() = RegistrationFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentRegistrationBinding.bind(view)
        binding.Register.setOnClickListener{
            (activity as MainActivity).navigateToFragment(LoginFragment.newInstance())
        }
    }
}