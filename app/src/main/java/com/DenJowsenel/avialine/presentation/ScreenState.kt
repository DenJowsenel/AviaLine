package com.DenJowsenel.avialine.presentation

import com.DenJowsenel.avialine.domain.model.Company

sealed class ScreenState {
        data class DataLoaded(val companies: List<Company>) : ScreenState()
        object Loading : ScreenState()
        data class Error(val error: String) : ScreenState()
}
