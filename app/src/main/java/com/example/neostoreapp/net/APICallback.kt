package com.example.neostoreapp.net

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



open class APICallback<T>(): Callback<T> {
    var noInternet:Boolean = false
    override fun onFailure(call: Call<T>?, t: Throwable?) {

        if(noInternet){
            //get data from cache or local db
            onResponse(200,null)
        }
    }
    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        onResponse(response?.code(),response?.body())
    }

    open fun onResponse(code:Int?,response: T?){

    }
}