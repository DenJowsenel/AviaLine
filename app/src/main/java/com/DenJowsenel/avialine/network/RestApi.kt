package com.DenJowsenel.avialine.network

import com.DenJowsenel.avialine.model.Company
import com.DenJowsenel.avialine.model.Review
import com.DenJowsenel.avialine.model.Route
import retrofit2.http.GET

interface RestApi {
    @GET("companies")
    suspend fun loadCompanies(): List<Company>
    @GET("routes")
    suspend fun loadRoutes(): List<Route>
    @GET("reviews")
    suspend fun loadReviews(): List<Review>

}