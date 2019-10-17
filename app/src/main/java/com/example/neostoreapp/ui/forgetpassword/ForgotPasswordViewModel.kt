package com.example.neostoreapp.ui.forgetpassword

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neostoreapp.services.ApiClient
import com.example.neostoreapp.ui.resetpassword.Reset1Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ForgotPasswordViewModel :ViewModel() {
    private val forgotPassword: MutableLiveData<ForgotPasswordResponse> = MutableLiveData()//create object of live data
    fun forgotResponse(): MutableLiveData<ForgotPasswordResponse> = forgotPassword
    fun forgotPassword(email: String)
    {
        Log.d("Tag","init1")
        ApiClient().apiServices.forgotPassword(email).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    if (it!=null)
                    {
                        //update the objects of the LiveData and  value will be updated whenever the main thread will be executed.
                        forgotPassword.postValue(it)
                    }
                },
                onError = {
                    forgotPassword.postValue(null)
                },
                onComplete = {

                }
            )
    }
}