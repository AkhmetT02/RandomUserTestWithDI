package com.example.randomusertest

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.randomusertest.adapter.UserAdapter
import com.example.randomusertest.di.App
import com.example.randomusertest.models.User
import com.example.randomusertest.presenters.MainPresenter
import com.example.randomusertest.views.MainView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView{

    @Inject lateinit var adapter: UserAdapter
    @InjectPresenter lateinit var presenter: MainPresenter

    private lateinit var recyclerUsers: RecyclerView
    private lateinit var loadingBar: ProgressBar
    private lateinit var emptyListTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.getAppComponent().inject(this)

        recyclerUsers = findViewById(R.id.recycler_users)
        loadingBar = findViewById(R.id.loading_bar)
        emptyListTxt = findViewById(R.id.empty_users_txt)


        recyclerUsers.layoutManager = LinearLayoutManager(this)
        recyclerUsers.adapter = adapter

        presenter.loadUsers(count = 20)

    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun setupUsers(users: List<User>) {
        adapter.setUsers(users = users)
        emptyListTxt.visibility = View.INVISIBLE
        recyclerUsers.visibility = View.VISIBLE
    }

    override fun setupEmptyUsers() {
        emptyListTxt.visibility = View.VISIBLE
        recyclerUsers.visibility = View.INVISIBLE
    }

    override fun startLoading() {
        loadingBar.visibility = View.VISIBLE
    }

    override fun endLoading() {
        loadingBar.visibility = View.INVISIBLE
    }
}