package com.DenJowsenel.avialine.model

import kotlinx.serialization.Serializable

@Serializable
data class Route(
    val route: String,
    val price: String,
    val place: String,
    val priceVip: String,
    val placeVip: String,
)