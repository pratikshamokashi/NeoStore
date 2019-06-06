package com.example.neostoreapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_register.*

class ForgotPasswordActivity :BaseActivity(){
    override var value= R.layout.activity_forgot_password

    override  fun getvalue()
    {
       btn_resend.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }    }
}
