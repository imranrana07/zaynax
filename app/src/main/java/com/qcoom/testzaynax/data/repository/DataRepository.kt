package com.qcoom.testzaynax.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.qcoom.testzaynax.data.model.ItemClass
import com.qcoom.testzaynax.data.source.remote.DataPagingSource
import kotlinx.coroutines.flow.Flow


class DataRepository{
    fun getData(): Flow<PagingData<ItemClass>> {
        return Pager(
                PagingConfig(
                        pageSize = 10,
                        enablePlaceholders = false
                ),
                pagingSourceFactory = { DataPagingSource() }
        ).flow
    }
}