package com.example.neostoreapp.View

import com.example.neostoreapp.models.LoginResponse

interface LoginView {
    fun loginValidation()
    fun loginSucess()
    fun loginFailure()
    fun response(res: LoginResponse)
}