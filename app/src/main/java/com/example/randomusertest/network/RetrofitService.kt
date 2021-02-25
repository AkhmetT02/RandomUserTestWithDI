package com.example.randomusertest.network

import com.example.randomusertest.models.UsersResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("api/")
    fun getRandomUsers(@Query("results") resultCount: Int): Call<UsersResult>
}