package com.example.neostoreapp.ui.login

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.neostoreapp.R.layout.activity_login
import com.example.neostoreapp.ui.base.MyApp
import com.example.neostoreapp.ui.forgetpassword.ForgotPasswordActivity
import com.example.neostoreapp.ui.home.HomeActivity
import com.example.neostoreapp.ui.registration.RegisterActivity
import com.example.neostoreapp.ui.resetpassword.Reset1PasswordActivity
import com.example.neostoreapp.ui.sample.SampleActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.header_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import com.example.neostoreapp.ui.base.BaseActivity as BaseActivity

class LoginActivity: BaseActivity(), LoginContract.LoginView {

    override var layout= activity_login
    var presnter = LoginPresenter(this)

    lateinit var sharedPreferences:SharedPreferences
    lateinit var editor:Editor
    override fun init() {

        sharedPreferences = getSharedPreferences("myPref", 0)
        editor = sharedPreferences.edit()
        linear_layout.visibility = View.GONE

        if (sharedPreferences.getBoolean("isLogin",false)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
            btn_login.setOnClickListener {
                val email = et_email.text.toString()
                val password = et_password.text.toString()
                val firstName=header_txt.text.toString()
                sharedPreferences= getSharedPreferences("myPref",0)
                editor.putString("Email",email)
                editor.putString("Password",password)
                editor.apply()
                val isValidate: Boolean = presnter.loginValidation(email, password)

                if (isValidate) {
                    presnter.login(email, password)
                }
            }
            btn_plus.setOnClickListener() {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            txt_forgot_password.setOnClickListener {
                val intent = Intent(this, ForgotPasswordActivity::class.java)
                startActivity(intent)
            }
        }

    override fun loginSucess(res: LoginResponse?) {
        Log.d("Tag","fa1il")
        showToast(res?.message)
        MyApp.instance.acess_token= res?.data?.accessToken.toString()
        editor.putString("access_token",res?.data?.accessToken.toString())
        editor.putString("firstName",res?.data?.firstName)
        editor.putString("lastName",res?.data?.lastName)
        editor.putBoolean("isLogin",true)
        editor.apply()
        header_txt.setText(res?.data?.firstName)
            et_email.setText("")
            et_password.setText("")
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
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