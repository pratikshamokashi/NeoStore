/*
package com.example.neostoreapp.ui.forgotpassword

import android.util.Log
import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import com.example.neostoreapp.ui.accountdetails.Response
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Retrofit

class MyAccountPresenter(myAccountView: MyAccountContract.MyAccountView) : MyAccountContract.Presenter{
    var mView: MyAccountContract.MyAccountView?=null
    init {
        this.mView = myAccountView
    }


    override fun getAccountDetails(accessToken: String?) {
        APIManager().getAccountDetails(object : APICallback<Response>()
        {
            override fun onSucess(code: Int?, response: com.example.neostoreapp.ui.accountdetails.Response?) {
                Log.d("tag","token check:"+mView)
                mView?.myaccountSucess(response?.data)
            }

            override fun onFail(
                    code: Int?,
                    response: retrofit2.Response<Response>?,
                    errorBody: ResponseBody?,
                    retrofit: Retrofit?
            ) {
                val jObjError = JSONObject(errorBody?.string())
                mView?.myaccountFailure("${jObjError.get("message")}")
            }
        },accessToken)

    }


    override fun start() {
    }

    override fun stop() {
    }


}*/
