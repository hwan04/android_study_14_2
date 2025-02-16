package com.alom.androidstudy2

import retrofit2.Call

class ItemRepositoryImpl : ItemRepository {
    override suspend fun getItem(): List<Data> {
        val response = RetrofitClient.itemApi.getItems()
        return response.data ?: emptyList()
    }

    override suspend fun addItem(item: itemRequest) {
        RetrofitClient.itemApi.addItems(item)
    }
}