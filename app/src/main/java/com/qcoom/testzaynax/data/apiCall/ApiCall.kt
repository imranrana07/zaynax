package com.qcoom.testzaynax.data.apiCall

import com.qcoom.testzaynax.data.model.DataClass
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiCall {


    @GET("category/get_activated_lists")
    suspend fun getData(
        @Query("page") page: Int
    ): Response<BaseResponse<DataClass>>

}