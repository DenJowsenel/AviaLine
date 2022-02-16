package com.DenJowsenel.avialine.domain.model

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["imageCompanyURL", "company_name", "company_desc"])
data class Company(
    val imageCompanyURL: String,
    val company_name : String,
    val company_desc : String,
)