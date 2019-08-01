package com.example.neostoreapp.ui.resetpassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import com.example.neostoreapp.services.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class ResetViewModel:ViewModel() {

    private val resetPassword:MutableLiveData<Reset1Response> = MutableLiveData()//create object of live data
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
                                //update the objects of the LiveData and  value will be updated whenever the main thread will be executed.
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