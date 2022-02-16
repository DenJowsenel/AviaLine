package com.DenJowsenel.avialine.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Review(
    val user_name: String,
    val rating: String,
    val product_desc: String
)