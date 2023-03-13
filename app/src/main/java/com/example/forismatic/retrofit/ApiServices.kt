package com.example.forismatic.retrofit

import com.example.forismatic.Model
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("api/1.0/?method=getQuote&format=json&lang=ru")
    suspend fun getQuote():Response<Model>
}