package com.example.neostoreapp.ui.registration

import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.base.BaseView

interface RegisterContract {
    interface RegisterView:BaseView{
        fun registerFailure()
        fun registerSucess(res: RegisterResponse?)

        fun showEmailError()
        fun showPasswordError()
        fun showFirstNameError()
        fun showLastNameEror()
        fun showConfirmPasswordError()
        fun showGenderError()
        fun showPhoneNumberError()
    }
    interface Presenter: BasePresenter {
        fun register(
            first_name:String,
            last_name:String,
            email:String,
            password:String,
            confirm_password:String,
            gender:String,
            phone_no: String
        )
        fun registerValidation(first_name:String,last_name:String,email:String,
                               password:String, confirm_password:String, gender:String, phone_no:String):Boolean
    }
}