package com.DenJowsenel.avialine.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.DenJowsenel.avialine.*
import com.DenJowsenel.avialine.adapter.CompanyAdapter
import com.DenJowsenel.avialine.databinding.FragmentCompaniesBinding
import com.DenJowsenel.avialine.model.Company
import com.DenJowsenel.avialine.network.NetworkService
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class CompaniesFragment : Fragment(R.layout.fragment_companies) {
    private lateinit var binding: FragmentCompaniesBinding

    companion object {
        fun newInstance() = CompaniesFragment()
    }

    private fun setLoading(isLoading: Boolean) = with(binding) {
        progressBar.isVisible = isLoading && !rvCompany.isVisible
        RefreshCompanies.isRefreshing = isLoading && rvCompany.isVisible
    }

    private fun setData(companies: List<Company>?) = with(binding) {
        rvCompany.isVisible = companies != null
        binding.rvCompany.layoutManager = LinearLayoutManager(context)
        binding.rvCompany.adapter =
            CompanyAdapter(companies ?: listOf()) {
                (activity as MainActivity).navigateToFragment(
                    RoutesFragment.newInstance()
                )
            }
        binding.icProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProfileFragment.newInstance())
        }
        binding.icClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(RegistrationFragment.newInstance())
        }
    }

    private fun setError(message: String?) = with(binding) {
        ErrLayout.isVisible = message != null
        textError.text = message
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCompaniesBinding.bind(view)
        merge(
            flowOf(Unit),
            binding.RefreshCompanies.onRefreshFlow(),
            binding.buttonError.onClickFlow()
        )
            .flatMapLatest { loadCompanies() }
            .distinctUntilChanged()
            .onEach {
                when (it) {
                    is ScreenState.DataLoaded -> {
                        setLoading(false)
                        setError(null)
                        setData(it.companies)
                    }
                    is ScreenState.Error -> {
                        setLoading(false)
                        setError(it.error)
                        setData(null)
                    }
                    ScreenState.Loading -> {
                        setLoading(true)
                        setError(null)
                    }
                }
            }
            .launchIn(lifecycleScope)

    }

    @ExperimentalSerializationApi
    private fun loadCompanies() = flow {
        emit(ScreenState.Loading)
        val companies = NetworkService.loadCompanies()
        emit(ScreenState.DataLoaded(companies))
    }
        .catch {
            emit(ScreenState.Error(getString(R.string.error)))
        }
}

