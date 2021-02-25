package com.example.randomusertest.di.modules

import com.example.randomusertest.network.RetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class RetrofitServiceInsModule {

    @Provides
    @Singleton
    fun provideRetrofitServiceIns(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }
}