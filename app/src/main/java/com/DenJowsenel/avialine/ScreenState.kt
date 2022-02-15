package com.DenJowsenel.avialine

import com.DenJowsenel.avialine.model.Company

sealed class ScreenState {
        data class DataLoaded(val companies: List<Company>) : ScreenState()
        object Loading : ScreenState()
        data class Error(val error: String) : ScreenState()
}
