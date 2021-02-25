package com.example.randomusertest.views

import com.example.randomusertest.models.User
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun showError(error: String)
    fun setupUsers(users: List<User>)
    fun setupEmptyUsers()
    fun startLoading()
    fun endLoading()
}