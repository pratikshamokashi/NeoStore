package com.example.neostoreapp.ui.accountdetails

import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import com.example.neostoreapp.R.layout.activity_my_account
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.editprofile.EditProfileActivity
import com.example.neostoreapp.ui.resetpassword.ResetPasswordActivity
import kotlinx.android.synthetic.main.activity_my_account.*
import kotlinx.android.synthetic.main.toolbar.*


class MyAccountActivity:BaseActivity(),MyAccountContract.MyAccountView{
    override val layout = activity_my_account
    val presenter = MyAccountViewModel(this)
    override val getPresenter: BasePresenter
        get() = presenter
    lateinit var sharedPreferences:SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun init() {
        menu_img.visibility=View.GONE
        txt_neostore1.setText("My Account")
        sharedPreferences = getSharedPreferences("myPref", 0)
         presenter.getAccountDetails(sharedPreferences.getString("access_token",null))

        ab_back_white.setOnClickListener {
            finish()
        }
        btn_resetPassword1.setOnClickListener {
            val intent=Intent(this,ResetPasswordActivity::class.java)
            startActivity(intent)
        }
        btn_edit_profile.setOnClickListener {
            Log.d("tag","editCheck")
            val intent=Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

    }

    override fun myaccountFailure(errorMsg: String) {
        showToast(errorMsg)
    }

    override fun myaccountSucess(res: Data?) {
        Log.d("Tag","sucess check: "+res?.userData?.dob)
       // showToast("Sucessfully. "+res?.)
        et_firstName.setText(res?.userData?.firstName)
        et_lastName.setText(res?.userData?.lastName)
        et_email.setText(res?.userData?.email)
        et_phn_no.setText(res?.userData?.phoneNo)
        et_dob.setText(res?.userData?.dob.toString())

    }

}