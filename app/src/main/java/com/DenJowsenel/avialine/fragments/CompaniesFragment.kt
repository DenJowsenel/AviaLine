package com.DenJowsenel.avialine.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.DenJowsenel.avialine.MainActivity
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.adapter.CompanyAdapter
import com.DenJowsenel.avialine.data.DataSource.Companies
import com.DenJowsenel.avialine.databinding.FragmentCompaniesBinding

class CompaniesFragment : Fragment(R.layout.fragment_companies) {
    companion object{
        fun newInstance() = CompaniesFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCompaniesBinding.bind(view)
        binding.rvCompany.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCompany.adapter = CompanyAdapter(Companies) {
            (activity as MainActivity).navigateToFragment(RoutesFragment.newInstance())
        }
        binding.icClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(RegistrationFragment.newInstance())
        }
        binding.icProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProfileFragment.newInstance())
        }
    }
}

