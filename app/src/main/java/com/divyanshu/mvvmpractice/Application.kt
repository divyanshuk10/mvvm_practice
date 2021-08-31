package com.divyanshu.mvvmpractice

import android.app.Application
import androidx.multidex.MultiDex
import com.divyanshu.mvvmpractice.di.NetworkComponent

class MyApplication : Application() {

    private lateinit var networkComponent: NetworkComponent
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this);
    }

}