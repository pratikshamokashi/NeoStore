package com.example.neostoreapp.ui.resetpassword

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.neostoreapp.services.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class ResetViewModel:ViewModel() {

    private val resetPassword:MutableLiveData<Reset1Response> = MutableLiveData()
    fun forgotResponse(): MutableLiveData<Reset1Response> = resetPassword
    fun forgotPassword(accessToken: String,old_password: String, password: String, confirm_password: String)
    {
        Log.d("Tag","init1")
        ApiClient().apiServices.resetPassword(accessToken,old_password,password,confirm_password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            if (it!=null)
                            {
                                resetPassword.postValue(it)
                            }
                        },
                        onError = {
                                resetPassword.postValue(null)
                        },
                        onComplete = {

                        }
                )
    }
}