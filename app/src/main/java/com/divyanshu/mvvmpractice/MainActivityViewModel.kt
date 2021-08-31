package com.divyanshu.mvvmpractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.divyanshu.mvvmpractice.di.NetworkServiceInterface
import com.divyanshu.mvvmpractice.model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var networkServiceInterface: NetworkServiceInterface

    private var liveDataList: MutableLiveData<RecyclerList> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<RecyclerList> {
        return liveDataList
    }

    fun makeAPICall() {
        val call = networkServiceInterface.getDataFromAPI("atl")
        call.enqueue(object : Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }
}