package com.example.neostoreapp.features.login

interface LoginView {
    fun loginValidation()
    fun loginSucess()
    fun loginFailure()
    fun response(res: LoginResponse)
}