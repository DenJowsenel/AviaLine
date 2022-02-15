package com.DenJowsenel.avialine.model

import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val imageCompanyURL: String,
    val company_name : String,
    val company_desc : String,
)