package com.DenJowsenel.avialine.data.network

import com.DenJowsenel.avialine.domain.model.Company
import com.DenJowsenel.avialine.domain.model.Review
import com.DenJowsenel.avialine.domain.model.Route
import retrofit2.http.GET

interface RestApi {
    @GET("companies")
    suspend fun loadCompanies(): List<Company>
    @GET("routes")
    suspend fun loadRoutes(): List<Route>
    @GET("reviews")
    suspend fun loadReviews(): List<Review>

}