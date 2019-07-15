package com.example.neostoreapp.ui.resetpassword

import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.registration.RegisterContract
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class ResetPasswordPresenter(resetpasswordView: ResetPasswordContract.ResetpasswordView) : ResetPasswordContract.Presenter {
    var mView:ResetPasswordContract.ResetpasswordView?=null
     init{
        this.mView=resetpasswordView
    }
    override fun changepassword(old_password: String, password: String, confirm_password: String) {
        APIManager().changePassword(old_password,password,confirm_password, object : APICallback<ResetResponse>(){
            override fun onFail(
                code: Int?,
                response: Response<ResetResponse>?,
                errorBody: ResponseBody?,
                retrofit: Retrofit?
            ) {
                val jObjError = JSONObject(errorBody?.string())
                mView?.resetPasswordFailure("${jObjError.get("message")}")
            }

            override fun onSucess(code: Int?, response: ResetResponse?) {
                mView?.resetPaaswordSucess(response)
            }

        })
    }

    override fun start() {
    }

    override fun stop() {
    }
}