package com.example.neostoreapp.ui.login

import com.example.neostoreapp.ui.base.BasePresenter

interface LoginContract {
    interface LoginView {
        fun loginValidation()
        fun loginFailure()
        fun loginSucess(res: LoginResponse)
    }
    interface Presenter:BasePresenter {
        fun login(email:String,password:String)
    }
}
