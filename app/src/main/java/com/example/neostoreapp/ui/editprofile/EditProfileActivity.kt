package com.example.neostoreapp.ui.editprofile

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import android.util.Base64
import android.util.Log
import android.view.View
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.header_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.BufferedInputStream
import java.net.URL

class EditProfileActivity : BaseActivity(), EditProfileContract.EditProfileView {
    @RequiresApi(Build.VERSION_CODES.O)
    override val layout = R.layout.activity_edit_profile
      val presenter = EditProfilePresenter( this)
         val getPresenter: BasePresenter
        get() = presenter
    val image = "https://www.gstatic.com/webp/gallery3/1.png"
    val data = image.toByteArray(charset("UTF-8"))
    lateinit var base64: String
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun init() {
        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            base64 = Base64.encodeToString(data, Base64.DEFAULT)
//            Base64.getDecoder().decode(base64)
        } else {
            Base64.decode(data,Base64.DEFAULT)
        }
        sharedPreferences = getSharedPreferences("myPref", 0)
        editor= sharedPreferences.edit()
        Picasso.with(this).load(image).into(img_profilepic)
        Log.d("tag", "editCheck1")
        //Picasso.with(this).load("https://www.gstatic.com/webp/gallery3/1.png").into(img_profilepic)
        txt_neostore1.setText("Edit Profile")
        menu_img.visibility = View.GONE
        ab_back_white.setOnClickListener {
            finish()
        }
        btn_submit.setOnClickListener {
            val firstName = et_editfirstName.text.toString()
            val lastName = et_editlastName.text.toString()
            val email = et_editemail.text.toString()
            val dob = et_dob.text.toString()
            val phone_no = et_editphn_no.text.toString()
            // val picasso=img_profilepic.borderColor.toString()

            val url: URL = URL("https://www.gstatic.com/webp/gallery3/1.png")
            val bufferedInputStream: BufferedInputStream = BufferedInputStream(url.openConnection().getInputStream())
            sharedPreferences = getSharedPreferences("myPref", 0)
            presenter.editProfile(sharedPreferences.getString("access_token", null), firstName, lastName, email, dob, phone_no, bufferedInputStream.toString())
        }
    }

    override fun editprofileSuccess(res: EditProfileResponse?) {
        Log.d("tag", "check2"+res?.data?.firstName)
       // header_txt.setText(res?.data?.lastName)
        editor.putString("firstName",res?.data?.firstName)
        editor.putString("lastName",res?.data?.lastName)
        editor.apply()
       // header_txt.text=res?.data?.firstName + res?.data?.lastName
        showToast(res?.message)

    }

    override fun editprofileFailure(errorMsg: String) {
        showToast(errorMsg)
    }


}

