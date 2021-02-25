package com.example.randomusertest.di.components

import com.example.randomusertest.MainActivity
import com.example.randomusertest.di.modules.*
import com.example.randomusertest.providers.MainProvider
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, AdapterModule::class, PicassoModule::class, RetrofitModule::class,
    RetrofitServiceInsModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(mainProvider: MainProvider)

}