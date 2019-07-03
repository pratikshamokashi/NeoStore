package com.example.neostoreapp.ui.login

import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.base.BaseView
import dagger.Component
import dagger.Provides
import javax.inject.Inject

@Component
interface LoginContract {
    interface LoginView : BaseView {
        fun showEmailError()
        fun showPasswordError()
        fun loginFailure(errorMsg: String)
        fun loginSucess(res: LoginResponse?)
    }

    interface Presenter : BasePresenter {
        fun login(email: String, password: String)
        fun loginValidation(email: String, password: String): Boolean
    }
}