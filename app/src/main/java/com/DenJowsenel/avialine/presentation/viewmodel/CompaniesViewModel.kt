package com.DenJowsenel.avialine.presentation.viewmodel

import android.content.Context
import com.DenJowsenel.avialine.data.database.DatabaseProvider
import com.DenJowsenel.avialine.data.network.NetworkService
import com.DenJowsenel.avialine.presentation.ScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import java.io.IOException


class CompaniesViewModel (
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val _screenState = MutableStateFlow<ScreenState> (ScreenState.Loading)
    val screenState : StateFlow<ScreenState> = _screenState
    private var job: Job? = null
    private val companiesDao = DatabaseProvider.provideDatabase(context).CompanyDAO()
    @ExperimentalSerializationApi
    fun loadData() {
        job?.cancel()
        job = coroutineScope.launch {
            try{
                _screenState.value = ScreenState.Loading
                val companies = try{
                    NetworkService.loadCompanies().also{
                        companiesDao.insertAll(it)
                    }
                } catch (ex: IOException){
                    companiesDao.getAll()
                }
                _screenState.value = ScreenState.DataLoaded(companies)
            } catch (ex: Throwable){
                _screenState.value = ScreenState.Error("Ошибка!")
            }
        }
    }
}
