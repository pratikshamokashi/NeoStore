package com.example.neostoreapp.ui.myorder

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neostoreapp.services.ApiClient
import com.example.neostoreapp.ui.mycartlisting.MyCartResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MyOrderViewModel:ViewModel() {

    private val myorderList:MutableLiveData<MyOrderResponse> = MutableLiveData()
    fun myorderList():MutableLiveData<MyOrderResponse> = myorderList
    fun myorderList(accessToken: String){
        ApiClient().apiServices.myorderList(accessToken).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            if(it != null)
                            {
                                myorderList.postValue(it)
                            }

                        },
                        onError = {
                            myorderList.postValue(null)
                        },
                        onComplete = {

                        }
                )
    }
}