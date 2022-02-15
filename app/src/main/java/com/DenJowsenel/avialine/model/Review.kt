package com.DenJowsenel.avialine.model

import kotlinx.serialization.Serializable

@Serializable
data class Review(
    val user_name: String,
    val rating: String,
    val product_desc: String
)