package com.DenJowsenel.avialine.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.DenJowsenel.avialine.MainActivity
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.adapter.RouteAdapter
import com.DenJowsenel.avialine.data.DataSource.Routes
import com.DenJowsenel.avialine.databinding.FragmentFlightRoutesBinding

class RoutesFragment : Fragment(R.layout.fragment_flight_routes) {
    companion object{
        fun newInstance() = RoutesFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFlightRoutesBinding.bind(view)
        binding.rvRoute.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRoute.adapter = RouteAdapter(Routes) {
            (activity as MainActivity).navigateToFragment(ReviewsFragment.newInstance())
        }
        binding.icClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(CompaniesFragment.newInstance())
        }
        binding.icProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProfileFragment.newInstance())
        }
    }
}
