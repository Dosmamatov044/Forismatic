package com.example.forismatic.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    //val interceptor = HttpLoggingInterceptor()

   // interceptor.level = HttpLoggingInterceptor.Level.BODY

//    val client= OkHttpClient.Builder()
//        .addInterceptor(interceptor)
//        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.forismatic.com/")//.client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiServices = retrofit.create(ApiServices::class.java)


}