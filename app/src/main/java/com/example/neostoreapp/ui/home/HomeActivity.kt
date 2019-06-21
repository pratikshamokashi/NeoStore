package com.example.neostoreapp.ui.home

import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.login.LoginContract
import com.example.neostoreapp.ui.login.LoginPresenter
import com.example.neostoreapp.ui.login.LoginResponse

class HomeActivity: BaseActivity(), LoginContract.LoginView  {
    override fun loginFailure(s: String) {

    }

    override fun showEmailError() {

    }

    override fun showPasswordError() {

    }



    override fun loginSucess(res: LoginResponse?) {

    }

    override val layout: Int
        get() = R.layout.activity_home
    var  presnter = LoginPresenter(this)
    override val getPresenter: BasePresenter
        get() = presnter

    override fun init() {

    }
    /*override var getPresenter: BasePresenter
        get() = getPresenter
        set(value) {}*/
    /*override var layout = R.layout.activity_home
    override fun init() {
       // setToolbar("home")*/
//}

}