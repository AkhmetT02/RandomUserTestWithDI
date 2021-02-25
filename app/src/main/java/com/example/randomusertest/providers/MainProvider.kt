package com.example.randomusertest.providers

import com.example.randomusertest.di.App
import com.example.randomusertest.models.UsersResult
import com.example.randomusertest.network.RetrofitService
import com.example.randomusertest.presenters.MainPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainProvider(private val count: Int, private val presenter: MainPresenter) {

    @Inject lateinit var mService: RetrofitService

    fun loadUsers() {
        App.getAppComponent().inject(this)

        mService.getRandomUsers(resultCount = count).enqueue(object: Callback<UsersResult> {
            override fun onFailure(call: Call<UsersResult>, t: Throwable) {
                if (t.message != null) {
                    presenter.showError(t.message!!)
                } else {
                    presenter.showError("No message")
                }
            }

            override fun onResponse(call: Call<UsersResult>, response: Response<UsersResult>) {
                response.body()?.results?.let { presenter.finishLoadUsers(it) }
            }
        })
    }
}