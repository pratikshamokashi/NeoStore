package com.example.neostoreapp.ui.resetpassword

import android.content.SharedPreferences
import android.view.View
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import kotlinx.android.synthetic.main.activity_reset_password.*
import kotlinx.android.synthetic.main.toolbar.*

class ResetPasswordActivity : BaseActivity(),ResetPasswordContract.ResetpasswordView{
    override val layout= R.layout.activity_reset_password
    override var getPresenter: BasePresenter
        get() = presenter
        set(value) {}
    var presenter=ResetPasswordPresenter(this)
    private lateinit var sharedPreferences: SharedPreferences


    override fun init() {
        txt_neostore1.setText("Reset Password")
        menu_img.visibility=View.GONE
        search_img.visibility=View.GONE
        btn_resetPassword.setOnClickListener {
            val oldPassword=et_current_password.text.toString()
            val password=et_new_password.text.toString()
            val newPassword=et_new_password.text.toString()
            sharedPreferences = getSharedPreferences("myPref", 0)
            presenter.changepassword(sharedPreferences.getString("access_token",null),oldPassword,password,newPassword)
        }
        ab_back_white.setOnClickListener {
            finish()
        }
            }

    override fun resetPasswordFailure(errorMsg: String) {
        showToast(errorMsg)
    }

    override fun resetPaaswordSucess(res: ResetResponse?) {
        showToast(res?.message)
        et_new_password.setText("")
        et_current_password.setText("")
        et_confirm_reset_password.setText("")
    }

    override fun showOldPassword() {
    et_current_password.error="old password is required"
    et_current_password.requestFocus()
    }

    override fun showConfirmPassword() {
        et_confirm_reset_password.error="confirm Password is required"
        et_confirm_reset_password.requestFocus()
}

override fun showPassword() {
    et_new_password.error="New password is required"
    et_new_password.requestFocus()
}
}
