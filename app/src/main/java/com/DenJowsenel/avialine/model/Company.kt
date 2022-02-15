package com.DenJowsenel.avialine.model

import androidx.annotation.DrawableRes

data class Company(
    @DrawableRes val company_img:Int,
    val company_name : String,
    val company_desc : String
)