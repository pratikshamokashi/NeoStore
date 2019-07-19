package com.example.neostoreapp.ui.resetpassword

import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.base.BaseView
import com.example.neostoreapp.ui.registration.RegisterResponse

interface ResetPasswordContract {
    interface ResetpasswordView: BaseView {
        fun resetPasswordFailure(errorMsg: String)
        fun resetPaaswordSucess(res: ResetResponse?)
        fun showOldPassword()
        fun showConfirmPassword()
        fun showPassword()
    }
    interface Presenter:BasePresenter{
        fun changepassword(accessToken: String?,old_password:String,
                           password: String,
                           confirm_password: String)
    }
}


