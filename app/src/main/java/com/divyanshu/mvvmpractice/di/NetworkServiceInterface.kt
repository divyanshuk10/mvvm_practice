package com.divyanshu.mvvmpractice.di

import com.divyanshu.mvvmpractice.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkServiceInterface {

    @GET("repositories")
    fun getDataFromAPI(@Query("q") query: String): Call<RecyclerList>
}