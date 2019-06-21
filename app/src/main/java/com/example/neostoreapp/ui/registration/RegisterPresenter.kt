package com.example.neostoreapp.ui.registration

import android.text.TextUtils
import android.util.Log
import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import com.example.neostoreapp.ui.registration.RegisterContract.RegisterView as RegisterView1
import com.example.neostoreapp.ui.registration.RegisterResponse as RegisterResponse

 class RegisterPresenter(registerView: RegisterContract.RegisterView):RegisterContract.Presenter {
        var mView:RegisterContract.RegisterView?=null
       override fun registerValidation(
           first_name: String, last_name: String, email: String,
           password: String, confirm_password: String, gender: String,
           phone_no: String
     ): Boolean {
           Log.d("Tag","validation method")
         when {
             TextUtils.isEmpty(first_name) -> {
                mView?.showFirstNameError()
                 return false
             }
             TextUtils.isEmpty(last_name) -> {
                mView?.showLastNameEror()
                 return false
             }
             TextUtils.isEmpty(email) -> {
                mView?.showEmailError()
                 return false
             }
             TextUtils.isEmpty(password) -> {
                 mView?.showPasswordError()
                 return false

             }
             TextUtils.isEmpty(confirm_password) -> {
                 mView?.showConfirmPasswordError()
                 return false

             }
             TextUtils.isEmpty(gender) -> {
                 mView?.showGenderError()
                 return false

             }
             TextUtils.isEmpty(phone_no) -> {
                 mView?.showPhoneNumberError()
                 return false
             }
             else -> return true
         }
     }
     init {
         this.mView= registerView
     }
     override fun start() {
     }

     override fun stop() {

     }


     override fun register(
         first_name: String,
         last_name: String,
         email: String,
         password: String,
         confirm_password: String,
         gender: String,
         phone_no: String
     ) {
         APIManager().register(
             first_name,
             last_name,
             email,
             password,
             confirm_password,
             gender,
             phone_no,
             object : APICallback<RegisterResponse>() {
                 override fun onSucess(code: Int?, response: RegisterResponse?) {
                     Log.d("Tag", "sucess2:" + response?.message)
                             mView?.registerSucess(response)
                      //400 -> {mView?.registerFailure(errormsg)}                    }

                 }
                 override fun onFail(
                     code: Int?,
                     response: Response<RegisterResponse>?,
                     errorBody: ResponseBody?,
                     retrofit: Retrofit?
                 ) {

                     val jObjError = JSONObject(errorBody?.string())
                     mView?.registerFailure("${jObjError.get("message")}")
                     //super.onFail(code, response, errorBody, retrofit)
                 }

             })
     }
 }