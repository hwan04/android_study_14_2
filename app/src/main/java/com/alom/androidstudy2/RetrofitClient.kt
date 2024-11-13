package com.alom.androidstudy2

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://goaplrynweyxovekoezl.supabase.co/rest/v1/"

    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY               //okhttp에서 어떤부분을 로깅할지 지정


        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()                      // 리퀘스트 빌더 만들고
                    .header("apikey", BuildConfig.API_KEY)    // 거기에 헤더 추가
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)                              // baseurl 달고
        .addConverterFactory(GsonConverterFactory.create())     // json을 data class로 편하게 바꿔주는 gson
        .client(createOkHttpClient())               // okhttp 클라이언트 달고
        .build()

    val goodsApi: GoodsApi = retrofit.create(GoodsApi::class.java)
}