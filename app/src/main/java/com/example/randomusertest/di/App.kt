package com.example.randomusertest.di

import android.app.Application
import com.example.randomusertest.di.components.AppComponent
import com.example.randomusertest.di.components.DaggerAppComponent
import com.example.randomusertest.di.modules.AppModule

class App : Application(){

    companion object {
        private lateinit var appComponent: AppComponent


        fun getAppComponent(): AppComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(context = this))
                .build()
    }
}