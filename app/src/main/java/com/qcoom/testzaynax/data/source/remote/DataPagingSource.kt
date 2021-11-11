package com.qcoom.testzaynax.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.qcoom.testzaynax.data.apiCall.ApiResponse
import com.qcoom.testzaynax.data.model.ItemClass
import com.qcoom.testzaynax.utils.ApiException
import com.qcoom.testzaynax.utils.apiCall
import retrofit2.HttpException
import java.io.IOException

class DataPagingSource: PagingSource<Int, ItemClass>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemClass> {
        val nextPage = params.key ?: 1
        return try {
            val response = ApiResponse.getResult { apiCall?.getData(nextPage)!!}
            LoadResult.Page(
                    data = response.data.items,
                    prevKey = if (nextPage>1) nextPage -1 else null,
                    nextKey = if (nextPage < response.data.totalPages) nextPage + 1 else null
            )
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }catch (e: ApiException){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ItemClass>): Int? {
        return state.anchorPosition
    }
}
