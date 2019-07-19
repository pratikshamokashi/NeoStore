package com.example.neostoreapp.ui.accountdetails

import android.util.Log
import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit

class MyAccountViewModel(myAccountView: MyAccountContract.MyAccountView):MyAccountContract.Presenter {

    var mView: MyAccountContract.MyAccountView?=null
    init {
        this.mView = myAccountView
    }


    override fun getAccountDetails(accessToken: String?) {
        APIManager().getAccountDetails(object :APICallback<com.example.neostoreapp.ui.accountdetails.Response>()
        {
            override fun onSucess(code: Int?, response: com.example.neostoreapp.ui.accountdetails.Response?) {
                Log.d("tag","token check:"+mView)
                mView?.myaccountSucess(response?.data)
            }

            override fun onFail(
                code: Int?,
                response: Response<com.example.neostoreapp.ui.accountdetails.Response>?,
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


}
