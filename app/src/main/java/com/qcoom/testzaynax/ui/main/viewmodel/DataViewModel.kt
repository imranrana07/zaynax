package com.qcoom.testzaynax.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.qcoom.testzaynax.data.model.ItemClass
import com.qcoom.testzaynax.data.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import java.util.*


class DataViewModel: ViewModel() {
    private val dataRepository = DataRepository()
    private var startDate: String? = null
    private var endDate: String? = null
    private var currentQueryString: String? = null
    private var currentResult: Flow<PagingData<ItemClass>>? = null
    val progressBar = MutableLiveData<Int>()

    fun getData(): Flow<PagingData<ItemClass>> {
        val result1: Flow<PagingData<ItemClass>> = dataRepository.getData().cachedIn(viewModelScope)
        currentResult = result1
        return result1
    }

}