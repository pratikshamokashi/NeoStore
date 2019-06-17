package com.example.neostoreapp.ui.login

import com.example.neostoreapp.R.layout.activity_login
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.login.LoginContract.Presenter
import kotlinx.android.synthetic.main.activity_login.*
import com.example.neostoreapp.ui.base.BaseActivity as BaseActivity

class LoginActivity(): BaseActivity(), LoginContract.LoginView {

    override var layout= activity_login
    override fun init() {
        btn_login.setOnClickListener() {
            getApi()
        }
    }
    override var getPresenter: BasePresenter
        get() = presenter
        set(value) {}
    var presenter=LoginPresenter(this)
   // lateinit var loginpresenter: LoginPresenter
    fun getApi() {
        lateinit var loginpresenter: LoginPresenter

        val email = et_email.text.toString()
        val password = et_password.text.toString()
        loginpresenter = LoginPresenter(this)
        loginpresenter.login(email, password)
    }

    override fun loginSucess(res: LoginResponse) {
        showToast(res.message)
    }
    override fun loginValidation() {
        showToast("Enter email and Password")
    }

    override fun loginFailure() {
        showToast("Login failed")
    }
}