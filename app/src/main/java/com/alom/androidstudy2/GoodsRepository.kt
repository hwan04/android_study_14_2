package com.alom.androidstudy2

class GoodsRepository(private val api: GoodsApi) {
    fun getItems(): APIResponse<List<Goods>> {
        val response = api.getItems().execute()
        if(response.isSuccessful){
            response.body()?.let { result ->
                return APIResponse.Success(result.data)
            }
        }
        
        return APIResponse.Error(response.message())
    }

    fun addItems(newGoods: NewGoods): APIResponse<Void> {
        val response = api.addItmes(newGoods).execute()
        if (response.isSuccessful) {
            return APIResponse.Success(null)
        }

        return APIResponse.Error(response.message())
    }
}