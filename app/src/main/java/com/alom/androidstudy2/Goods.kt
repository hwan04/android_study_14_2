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