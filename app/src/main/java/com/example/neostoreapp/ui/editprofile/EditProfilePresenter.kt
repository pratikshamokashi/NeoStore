package com.example.neostoreapp.ui.editprofile

import android.util.Log
import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit

class EditProfilePresenter(editProfileView: EditProfileContract.EditProfileView) : EditProfileContract.Presenter {

    var mView: EditProfileContract.EditProfileView? = null

    companion object {
        private val TAG = EditProfilePresenter::class.qualifiedName
    }

    init {
        this.mView = editProfileView
    }

    override fun editProfile(firstName: String, lastName: String, email: String, dob: String, phone_no: String, base64: String) {
        Log.d(TAG, "check by ak success 1")
        APIManager().editProfile(firstName, lastName, email, dob, phone_no, base64, object : APICallback<EditProfileResponse>() {
            override fun onSucess(code: Int?, response: EditProfileResponse?) {
                Log.d(TAG, "check by ak success 2")
                mView?.editprofileSuccess(response)
            }

            override fun onFail(
                    code: Int?,
                    response: Response<EditProfileResponse>?,
                    errorBody: ResponseBody?,
                    retrofit: Retrofit?
            ) {
                Log.d(TAG, "check by ak success 3")
                val jObjError = JSONObject(errorBody?.string())
                mView?.editprofileFailure("${jObjError.get("message")}")
            }


        })
        Log.d(TAG, "check by ak success 4")
    }


    override fun start() {

    }

    override fun stop() {
    }


}