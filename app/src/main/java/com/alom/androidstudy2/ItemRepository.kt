package com.alom.androidstudy2

interface ItemRepository {
    suspend fun getItem(): List<Data>
    suspend fun addItem(item: itemRequest)
}