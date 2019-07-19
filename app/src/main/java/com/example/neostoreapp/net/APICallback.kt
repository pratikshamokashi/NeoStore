package com.example.neostoreapp.net

import android.util.Log
import com.example.neostoreapp.services.ApiClient
import com.example.neostoreapp.ui.editprofile.EditProfilePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit


open class APICallback<T>() : Callback<T> {
    var noInternet: Boolean = false

    companion object {
        private val TAG = APICallback::class.qualifiedName
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        Log.d(TAG, "check by ak success 9:"+t?.message)
        if (noInternet) {
            Log.d(TAG, "check by ak success 10")
            //get data from cache or local db
            onSucess(200, null)
        }
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        Log.d("Tag", "res1" + response + response?.errorBody())
        Log.d(TAG, "check by ak success 5")
        if (response?.errorBody() != null) {
            Log.d("Tag","failure")
            onFail(response.code(), response, response.errorBody(),ApiClient.retrofit)
            Log.d(TAG, "check by ak success 6")
        } else {
            Log.d("Tag","Sucess")
            onSucess(response?.code(), response?.body())
            Log.d(TAG, "check by ak success 7:"+response?.body())
        }
        Log.d("Tag", "res2")
        Log.d(TAG, "check by ak success 8")
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