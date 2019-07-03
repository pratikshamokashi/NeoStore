package com.example.neostoreapp.dagger

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.neostoreapp.ui.login.LoginActivity
import com.example.neostoreapp.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var app: Activity) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

}


