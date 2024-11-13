package com.alom.androidstudy2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface GoodsApi {
    @POST("rpc/add_item2")
    fun addItmes(@Body newItem: NewGoods):Call<Void>

    @POST("rpc/get_item2")
    fun getItems(): Call<ApiResponse>
}