package com.example.neostoreapp.ui.forgotpassword

import android.content.Intent
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.registration.RegisterActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : BaseActivity(){
    override var getPresenter: BasePresenter
        get() = getPresenter
        set(value) {}
    override var layout= R.layout.activity_forgot_password
    override  fun init()
    {
       btn_resend.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }    }
}
