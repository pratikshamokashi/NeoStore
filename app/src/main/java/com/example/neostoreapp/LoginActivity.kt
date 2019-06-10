package com.example.neostoreapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*

 class LoginActivity : BaseActivity() {
    override var value= R.layout.activity_login
       override fun init() {
           btn_login.setOnClickListener {
               val intent = Intent(this, HomeActivity::class.java)
               startActivity(intent)
           }
           btn_plus.setOnClickListener {
             val intent = Intent(this, RegisterActivity::class.java)
             startActivity(intent)
         }
         txt_forgot_password.setOnClickListener {
         val intent = Intent(this,ForgotPasswordActivity::class.java)
             startActivity(intent)
         }

     }
}
