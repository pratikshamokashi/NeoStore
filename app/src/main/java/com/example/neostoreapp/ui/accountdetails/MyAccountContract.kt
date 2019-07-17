package com.example.neostoreapp.ui.accountdetails

import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.base.BaseView

interface MyAccountContract {
    interface MyAccountView:BaseView{
        fun myaccountFailure(errorMsg: String)
        fun myaccountSucess(res: Data?)
    }
    interface Presenter:BasePresenter{
        fun getAccountDetails()
    }
}