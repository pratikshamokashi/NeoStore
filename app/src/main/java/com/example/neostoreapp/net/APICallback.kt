package com.example.neostoreapp.net

import android.util.Log
import com.example.neostoreapp.services.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit


open class APICallback<T>() : Callback<T> {
    var noInternet: Boolean = false
    override fun onFailure(call: Call<T>?, t: Throwable?) {

        if (noInternet) {
            //get data from cache or local db
            onSucess(200, null)
        }
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        Log.d("Tag", "res1" + response + response?.errorBody())
        if (response?.errorBody() != null) {
            Log.d("Tag","failure")
            onFail(response.code(), response, response.errorBody(),ApiClient.retrofit)
        } else {
            Log.d("Tag","Sucess")
            onSucess(response?.code(), response?.body())
        }
        Log.d("Tag", "res2")
    }

    open fun onSucess(code: Int?, response: T?) {

    }

    open fun onFail(
        code: Int?,
        response: Response<T>?,
        errorBody: ResponseBody?,
        retrofit: Retrofit?
    ) {

    }
}