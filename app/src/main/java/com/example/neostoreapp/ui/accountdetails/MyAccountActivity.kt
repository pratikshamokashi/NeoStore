package com.example.neostoreapp.ui.accountdetails

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.neostoreapp.R.layout.activity_my_account
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.editprofile.EditProfileActivity
import com.example.neostoreapp.ui.resetpassword.Reset1PasswordActivity
import kotlinx.android.synthetic.main.activity_my_account.*
import kotlinx.android.synthetic.main.toolbar.*


class MyAccountActivity:BaseActivity() {

    override val layout = activity_my_account

    private lateinit var sharedPreferences: SharedPreferences
    lateinit  var viewModel: MyAccountViewModel

    override fun init() {

        menu_img.visibility= View.GONE
        txt_neostore1.setText("My Account")

        viewModel=ViewModelProviders.of(this).get(MyAccountViewModel::class.java)
        sharedPreferences = getSharedPreferences("myPref", 0)
        viewModel.getAccountDetails(sharedPreferences.getString("access_token",null))


        ab_back_white.setOnClickListener {
            finish()
        }
        viewModel.accountDetails().observe(this, Observer<Response>{
            if(it != null)
            {
                myaccountSucess(it)
            }
            else{
                failure()
            }
        })

        btn_resetPassword1.setOnClickListener {
            val intent=Intent(this,Reset1PasswordActivity::class.java)
            startActivity(intent)

        }
        btn_edit_profile.setOnClickListener {
            Log.d("tag","editCheck")
            val intent=Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
    private fun myaccountSucess(res: Response?) {
        Log.d("Tag","sucess check: "+ (res?.data?.userData?.firstName))

        et_firstName.setText(res?.data?.userData?.firstName)
        et_lastName.setText(res?.data?.userData?.lastName)
        et_email.setText(res?.data?.userData?.email)
        et_phn_no.setText(res?.data?.userData?.phoneNo)
        et_dob.setText(res?.data?.userData?.dob.toString())

    }
    private fun failure(){
        Toast.makeText(this,"failed to get account details",Toast.LENGTH_SHORT).show()
    }
}
