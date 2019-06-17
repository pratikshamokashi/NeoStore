package com.example.neostoreapp.activity

import android.content.Intent
import com.example.neostoreapp.R
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : BaseActivity(){
    override var value= R.layout.activity_forgot_password
    override  fun init()
    {
       btn_resend.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }    }
}
