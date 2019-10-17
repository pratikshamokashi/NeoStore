package com.example.neostoreapp.ui.accountdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neostoreapp.services.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class MyAccountViewModel:ViewModel() {

    private val accountDetails:MutableLiveData<com.example.neostoreapp.ui.accountdetails.Response> = MutableLiveData()
    fun accountDetails():MutableLiveData<com.example.neostoreapp.ui.accountdetails.Response> = accountDetails

    fun getAccountDetails(accessToken: String){
        ApiClient().apiServices.getAccountDetails(accessToken).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            if(it != null)
                            {
                                accountDetails.postValue(it)
                            }
                        },onError = {

                                accountDetails.postValue(null)
                         },
                        onComplete = {

                        }

                )

    }


}
