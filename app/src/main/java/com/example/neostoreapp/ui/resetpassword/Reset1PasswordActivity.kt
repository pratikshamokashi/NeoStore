package com.example.neostoreapp.ui.resetpassword

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_forgot_password.btn_resetPassword
import kotlinx.android.synthetic.main.activity_forgot_password.et_current_password
import kotlinx.android.synthetic.main.activity_forgot_password.et_new_password
import kotlinx.android.synthetic.main.toolbar.*

class Reset1PasswordActivity : BaseActivity(){

    override var layout= R.layout.activity_forgot_password
    private lateinit var sharedPreferences: SharedPreferences

    lateinit  var viewModel: ResetViewModel
    override  fun init()
    {
        txt_neostore1.setText("Reset Password")
        menu_img.visibility= View.GONE
        search_img.visibility= View.GONE
        Log.d("Tag","init")
        viewModel=ViewModelProviders.of(this).get(ResetViewModel::class.java)
        btn_resetPassword.setOnClickListener {
            Log.d("Tag","butonClick")
            val oldPassword=et_current_password.text.toString()
            val password=et_new_password.text.toString()
            val confirm_password=et_confirm_reset_password1.text.toString()
           sharedPreferences = getSharedPreferences("myPref", 0)
            viewModel.forgotPassword(sharedPreferences.getString("access_token",null),oldPassword,password,confirm_password)

        }
        ab_back_white.setOnClickListener {
            finish()
        }

        viewModel.forgotResponse().observe(this,Observer<Reset1Response>{
            if(it!=null)
            {
                sucessResetPassword(it)
            }
            else{
                failure()
            }
        })

        /* btn_resend.setOnClickListener {
              val intent = Intent(this, RegisterActivity::class.java)
              startActivity(intent)
          } */   }
    private fun sucessResetPassword(response: Reset1Response)
    {
        showToast(response.message)
        et_new_password.setText("")
        et_current_password.setText("")
        et_confirm_reset_password1.setText("")
    }
    private fun failure(){
       showError()
    }
}