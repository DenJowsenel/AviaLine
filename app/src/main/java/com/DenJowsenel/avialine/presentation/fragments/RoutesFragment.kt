package com.DenJowsenel.avialine.presentation.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.DenJowsenel.avialine.presentation.MainActivity
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.presentation.adapter.RouteAdapter
import com.DenJowsenel.avialine.databinding.FragmentFlightRoutesBinding
import com.DenJowsenel.avialine.data.network.NetworkService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi

class RoutesFragment : Fragment(R.layout.fragment_flight_routes) {
    private lateinit var binding: FragmentFlightRoutesBinding
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ context,exception ->
        exception.printStackTrace()
        binding.progressBar.visibility = GONE
        binding.rvRoute.adapter =
            RouteAdapter(listOf()) {}
        binding.RefreshRoutes.isRefreshing = false
        Snackbar.make(
            requireView(),
            getString(R.string.error),
            Snackbar.LENGTH_SHORT
        ).setBackgroundTint(Color.parseColor("#ED4337"))
            .setActionTextColor(Color.parseColor("#FFFFFF"))
            .show()
    }
    private val scope =
        CoroutineScope(Dispatchers.Main + SupervisorJob() + coroutineExceptionHandler)

    companion object{
        fun newInstance() = RoutesFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFlightRoutesBinding.bind(view)
        binding.icClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(CompaniesFragment.newInstance())
        }
        binding.icProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProfileFragment.newInstance())
        }

        loadRoutes()

        binding.RefreshRoutes.setOnRefreshListener {
            binding.RefreshRoutes.isRefreshing = true
            loadRoutes()
            binding.RefreshRoutes.isRefreshing = false
        }
    }

    @ExperimentalSerializationApi
    private fun loadRoutes() {
        scope.launch {
            val routes = NetworkService.loadRoutes()
            binding.rvRoute.layoutManager = LinearLayoutManager(context)
            binding.rvRoute.adapter =
                RouteAdapter(routes) {
                    (activity as MainActivity).navigateToFragment(
                        ReviewsFragment.newInstance())
                }
            binding.progressBar.visibility = GONE
            binding.RefreshRoutes.isRefreshing = false
        }
    }
}
