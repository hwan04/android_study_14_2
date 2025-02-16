package com.alom.androidstudy2

import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("result")
    val result: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: List<Data>
)

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("time")
    val time: String
)
