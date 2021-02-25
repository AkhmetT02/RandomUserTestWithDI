package com.example.randomusertest.di.modules

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

@Module
class PicassoModule {

    @Provides
    fun picasso(context: Context): Picasso {
        return Picasso.Builder(context).build()
    }
}