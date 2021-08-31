package com.divyanshu.mvvmpractice.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    private val baseURL = "https://api.github.com/search/"//repositories?q=newyork

    @Singleton
    @Provides
    fun getNetworkServiceInterface(retrofit: Retrofit): NetworkServiceInterface {
        return retrofit.create(NetworkServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}