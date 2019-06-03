package com.example.neostoreapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val img_account = findViewById(R.id.img_account) as ImageView
        img_account.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        val txt_forgot_password = findViewById(R.id.txt_forgot_password) as TextView
        txt_forgot_password.setOnClickListener {

            val intent1 = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent1)
        }
    }
}
