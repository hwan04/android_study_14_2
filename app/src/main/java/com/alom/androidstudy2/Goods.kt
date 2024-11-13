package com.alom.androidstudy2

import com.google.gson.annotations.SerializedName

data class Goods(
    val id: Int,
    val title: String,
    val price: String,
    val imageUrl: String,
    val time: String
)

data class NewGoods(
    @SerializedName("p_title")
    val p_title: String,

    @SerializedName("p_price")
    val p_price: String,

    @SerializedName("p_time")
    val p_time: String
)

data class ApiResponse(
    val result: Int,
    val message: String,
    val data: List<Goods>
)

sealed class APIResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : APIResponse<T>(data)
    class Loading<T>(data: T? = null) : APIResponse<T>(data)
    class Error<T>(message: String, data: T? = null) : APIResponse<T>(data, message)
}