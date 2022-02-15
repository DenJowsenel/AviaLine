package com.DenJowsenel.avialine.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.DenJowsenel.avialine.MainActivity
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    companion object{
        fun newInstance() = LoginFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLoginBinding.bind(view)
        binding.button.setOnClickListener{
            (activity as MainActivity).navigateToFragment(CompaniesFragment.newInstance())
        }
    }
}