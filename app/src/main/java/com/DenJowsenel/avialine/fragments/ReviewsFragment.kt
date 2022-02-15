package com.DenJowsenel.avialine.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.DenJowsenel.avialine.MainActivity
import com.DenJowsenel.avialine.R
import com.DenJowsenel.avialine.adapter.ReviewAdapter
import com.DenJowsenel.avialine.data.DataSource.Reviews
import com.DenJowsenel.avialine.databinding.FragmentReviewsBinding

class ReviewsFragment : Fragment(R.layout.fragment_reviews) {
    companion object{
        fun newInstance() = ReviewsFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentReviewsBinding.bind(view)
        binding.rvReview.layoutManager = LinearLayoutManager(requireContext())
        binding.rvReview.adapter = ReviewAdapter(Reviews) {}
        binding.icClose.setOnClickListener {
            (activity as MainActivity).navigateToFragment(RoutesFragment.newInstance())
        }
        binding.icProfile.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProfileFragment.newInstance())
        }
    }
}
