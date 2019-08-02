package com.example.neostoreapp.ui.address

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neostoreapp.services.ApiClient
import com.example.neostoreapp.ui.resetpassword.Reset1Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class AddressViewModel:ViewModel() {
    private val orderplace:MutableLiveData<OrderResponse> = MutableLiveData()
    fun orderPlaced() :MutableLiveData<OrderResponse> = orderplace
    fun orderPlaced(accessToken:String,address:String){
        ApiClient().apiServices.orderPlaced(accessToken,address).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            if (it != null)
                            {
                                orderplace.postValue(it)
                            }
                        },
                        onError = {
                            orderplace.postValue(null)
                        },
                        onComplete = {

                        }
                )
    }

}