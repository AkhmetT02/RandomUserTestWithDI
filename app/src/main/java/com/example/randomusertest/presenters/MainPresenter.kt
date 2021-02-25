package com.example.randomusertest.presenters

import com.example.randomusertest.models.User
import com.example.randomusertest.providers.MainProvider
import com.example.randomusertest.views.MainView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    fun loadUsers(count: Int) {
        viewState.startLoading()
        MainProvider(count = count, presenter = this).loadUsers()
    }

    fun finishLoadUsers(users: List<User>) {

        viewState.endLoading()
        if (users.isEmpty()) {
            viewState.setupEmptyUsers()
        }

        viewState.setupUsers(users = users)

    }

    fun showError(error: String) {
        viewState.showError(error = error)
    }
}