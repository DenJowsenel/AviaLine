package com.DenJowsenel.avialine.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val imageCompanyURL: String,
    val company_name : String,
    val company_desc : String,
)