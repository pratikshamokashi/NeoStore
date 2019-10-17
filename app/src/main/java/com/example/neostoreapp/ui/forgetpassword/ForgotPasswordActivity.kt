package com.example.neostoreapp.ui.forgetpassword

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.resetpassword.Reset1Response
import com.example.neostoreapp.ui.resetpassword.ResetViewModel
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_forgot_password2.*
import kotlinx.android.synthetic.main.toolbar.*

class ForgotPasswordActivity : BaseActivity() {
    override val layout: Int =R.layout.activity_forgot_password2
    lateinit  var viewModel: ForgotPasswordViewModel
    override fun init() {
      linear_layout.visibility=View.GONE
        btn_forgotPassword.setOnClickListener(){
          //  btn_forgotPassword.setBackgroundColor(Color.WHITE)
            val email=et_forgotpasswordemail.text.toString()
            viewModel.forgotPassword(email)
        }
        viewModel= ViewModelProviders.of(this).get(ForgotPasswordViewModel::class.java)
        viewModel.forgotResponse().observe(this, Observer{
            //3. Create the observer which updates the UI.
            if(it!=null)

                sucessResetPassword (it)
            else{

            }
        })
        ab_back_white.setOnClickListener {
            finish()
        }
    }
    private fun sucessResetPassword(response: ForgotPasswordResponse)
    {
        showToast(response.message)
    }
}
