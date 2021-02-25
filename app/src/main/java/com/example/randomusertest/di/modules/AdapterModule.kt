package com.example.randomusertest.di.modules

import com.example.randomusertest.adapter.UserAdapter
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

@Module(includes = [PicassoModule::class])
class AdapterModule {

    @Provides
    fun provideUserAdapter(picasso: Picasso) : UserAdapter {
        return UserAdapter(picasso = picasso)
    }
}