package com.example.neostoreapp.ui.editprofile

import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.base.BaseView

interface EditProfileContract {
    interface EditProfileView:BaseView{
        fun editprofileSuccess(res:EditProfileResponse)
        fun editprofileFailure(errorMsg: String)
    }
    interface Presenter:BasePresenter{
        fun editProfile(email:String,dob:String,phone_no:String,profile_pic:String)
    }
}