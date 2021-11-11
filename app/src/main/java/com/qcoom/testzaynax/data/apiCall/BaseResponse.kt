package com.qcoom.testzaynax.data.apiCall

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (
        @SerializedName("success")
        val success: Boolean,
        val data: T,
        @SerializedName("message")
        val message: String,

)