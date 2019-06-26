package com.example.neostoreapp.ui.login

import android.content.Intent
import android.util.Log
import com.example.neostoreapp.R.layout.activity_login
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.home.HomeActivity
import com.example.neostoreapp.ui.registration.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import com.example.neostoreapp.ui.base.BaseActivity as BaseActivity

class LoginActivity: BaseActivity(), LoginContract.LoginView {

    override var layout= activity_login
    var  presnter = LoginPresenter(this)
    override val getPresenter: BasePresenter
        get() = presnter

    override fun init() {
        btn_login.setOnClickListener() {
            val email = et_email.text.toString()
            val password = et_password.text.toString()

            val isValidate: Boolean = presnter.loginValidation(email, password)

            if(isValidate)
            {
                presnter.login(email, password)
            }
        }
        btn_plus.setOnClickListener()
        {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
        }
      /*  btn_resend.setOnClickListener()
        {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }*/
    }

    override fun loginSucess(res: LoginResponse?) {
        Log.d("Tag","fa1il")
           showToast(res?.message)
            et_email.setText("")
            et_password.setText("")
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            }

   override fun loginFailure(errorMsg: String) {
       Log.d("Tag","fail")
        showToast(errorMsg)
   }
    override fun showEmailError() {
        et_email.error="Email is required"
        et_email.requestFocus()
    }
   override fun showPasswordError() {
        et_password.error = "Password is required"
        et_password.requestFocus()
    }

}