package com.example.neostoreapp.ui.editprofile

import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit

class EditProfilePresenter(editProfileView: EditProfileContract.EditProfileView):EditProfileContract.Presenter {

    var mView:EditProfileContract.EditProfileView?=null
    init {
        this.mView=editProfileView
    }
    override fun editProfile(email:String,dob:String,phone_no:String,profile_pic:String) {
        APIManager().editProfile(email,dob,phone_no,profile_pic,object :APICallback<EditProfileResponse>()
        {
            override fun onSucess(code: Int?, response: EditProfileResponse?) {
                mView?.editprofileSuccess(response!!)
            }

            override fun onFail(
                code: Int?,
                response: Response<EditProfileResponse>?,
                errorBody: ResponseBody?,
                retrofit: Retrofit?
            ) {
                val jObjError = JSONObject(errorBody?.string())
                mView?.editprofileFailure("${jObjError.get("message")}")            }
        })

    }


    override fun start() {

    }
    override fun stop() {
    }


}