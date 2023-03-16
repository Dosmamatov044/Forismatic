package com.example.forismatic.di

import com.example.forismatic.retrofit.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun providesBaseUrl():String="https://api.forismatic.com/"



    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URl:String): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URl)//.client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit):ApiServices=retrofit.create(ApiServices::class.java)


}