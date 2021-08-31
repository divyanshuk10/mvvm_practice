package com.divyanshu.mvvmpractice.di

import com.divyanshu.mvvmpractice.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)
}