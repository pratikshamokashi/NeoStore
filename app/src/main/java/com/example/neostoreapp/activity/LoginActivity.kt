package com.example.neostoreapp.activity

import android.util.Log
import android.widget.Toast
import com.example.neostoreapp.Presenter.LoginPresenter
import com.example.neostoreapp.R.layout.activity_login
import com.example.neostoreapp.View.LoginView
import com.example.neostoreapp.models.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import com.example.neostoreapp.activity.BaseActivity as BaseActivity

class LoginActivity(): BaseActivity(), LoginView {
  override var value= activity_login
    override fun init() {
        btn_login.setOnClickListener() {
            getApi()
        }
    }
    lateinit var loginpresenter: LoginPresenter
    fun getApi() {
        val email = et_email.text.toString()
        val password = et_password.text.toString()
        loginpresenter = LoginPresenter(this)
        loginpresenter.login(email, password)
    }

    override fun response(res: LoginResponse) {
        showToast(res.message)
        //Toast.makeText(this,res.message,Toast.LENGTH_SHORT).show()

    }
    override fun loginValidation() {
        showToast("Enter email and Password")
    }

    override fun loginSucess() {
        showToast("Login Sucessfully..")
    }

    override fun loginFailure() {
        showToast("Login failed")
    }

}