package com.DenJowsenel.avialine.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.DenJowsenel.avialine.MainActivity
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.adapter.CompanyAdapter
import com.DenJowsenel.avialine.databinding.FragmentCompaniesBinding
import com.DenJowsenel.avialine.network.NetworkService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class CompaniesFragment : Fragment(R.layout.fragment_companies) {
    private lateinit var binding: FragmentCompaniesBinding
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ context,exception ->
        exception.printStackTrace()
        binding.progressBar.visibility = GONE
        binding.rvCompany.adapter =
            CompanyAdapter(listOf()) {}
        binding.RefreshCompanies.isRefreshing = false
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
        fun newInstance() = CompaniesFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCompaniesBinding.bind(view)
        binding.icClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(RegistrationFragment.newInstance())
        }
        binding.icProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProfileFragment.newInstance())
        }

        loadCompanies()

        binding.RefreshCompanies.setOnRefreshListener {
            binding.RefreshCompanies.isRefreshing = true
            loadCompanies()
            binding.RefreshCompanies.isRefreshing = false
        }
    }

    @ExperimentalSerializationApi
    private fun loadCompanies() {
        scope.launch {
            val companies = NetworkService.loadCompanies()
            binding.rvCompany.layoutManager = LinearLayoutManager(context)
            binding.rvCompany.adapter =
                CompanyAdapter(companies) {
                    (activity as MainActivity).navigateToFragment(
                        RoutesFragment.newInstance())
                }
            binding.progressBar.visibility = GONE
            binding.RefreshCompanies.isRefreshing = false
        }
    }
}


