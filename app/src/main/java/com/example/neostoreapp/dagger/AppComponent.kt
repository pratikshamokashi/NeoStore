package com.example.neostoreapp.dagger

import com.example.neostoreapp.ui.login.LoginActivity
import com.example.neostoreapp.ui.login.LoginPresenter
import dagger.Component

//@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(loginActivity: LoginActivity)
}