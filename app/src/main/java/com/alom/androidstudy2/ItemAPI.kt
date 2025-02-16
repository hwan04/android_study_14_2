package com.alom.androidstudy2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ItemAPI {
    @POST("rpc/add_item2")
    suspend fun addItems(
        @Body body: itemRequest
    ): Unit

    @POST("rpc/get_item2")
    suspend fun getItems(): ItemResponse
}