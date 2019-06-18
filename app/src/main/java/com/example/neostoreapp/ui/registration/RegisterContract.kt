package com.example.neostoreapp.ui.registration

import com.example.neostoreapp.ui.base.BasePresenter

interface RegisterContract {
    interface RegisterView {
        fun registerValidation()
        fun registerFailure()
        fun registerSucess(res: RegisterResponse)
    }
    interface Presenter: BasePresenter {
        fun register(
            firstName:String,
            lastName:String,
            email:String,
            password:String,
            confirmPassword:String,
            gender:String,
            phoneNumber: String
        )
    }
}