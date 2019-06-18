package com.example.neostoreapp.ui.login

import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.base.BaseView

interface LoginContract {
    interface LoginView:BaseView{
        fun emailError()
        fun showPasswordError()

        fun loginFailure()
        fun loginSucess(res: LoginResponse)
    }
    interface Presenter:BasePresenter {
        fun login(email:String,password:String)
        fun loginValidation(email: String,password: String):Boolean
    }
}