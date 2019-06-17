package com.example.neostoreapp.ui.home

import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.login.LoginContract

class HomeActivity : BaseActivity() {
    override var getPresenter: BasePresenter
        get() = getPresenter
        set(value) {}
    override var layout = R.layout.activity_home
    override fun init() {
       // setToolbar("home")
    }

}