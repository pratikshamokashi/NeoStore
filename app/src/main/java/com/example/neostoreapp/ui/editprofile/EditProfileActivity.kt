package com.example.neostoreapp.ui.editprofile

import android.content.Context
import android.util.Log
import android.view.View
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.toolbar.*

class EditProfileActivity(context:Context) : BaseActivity(),EditProfileContract.EditProfileView {
    override val layout = R.layout.activity_edit_profile
    val presenter=EditProfilePresenter(this)
    override val getPresenter: BasePresenter
    get() = presenter

    private var context: Context? = context

    override fun init() {
        Log.d("tag","editCheck1")
        txt_neostore1.setText("Edit Profile")
        menu_img.visibility= View.GONE
        ab_back_white.setOnClickListener{
            finish()
        }
        btn_submit.setOnClickListener {
            val email = et_editemail.text.toString()
            val dob =et_dob.text.toString()
            val phone_no=et_editphn_no.text.toString()
            Picasso.with(context).load("https://images.app.goo.gl/sAryzgwBMDRTAJtX6").into(img_profilepic)
            //presenter.editProfile(email,dob,phone_no,profile_pic)
        }
    }
    override fun editprofileSuccess(res: EditProfileResponse) {
        showToast(res.message)
    }

    override fun editprofileFailure(errorMsg: String) {
        showToast(errorMsg)
    }




}
