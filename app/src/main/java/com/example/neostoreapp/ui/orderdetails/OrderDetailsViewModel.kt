package com.example.neostoreapp.ui.orderdetails

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neostoreapp.services.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class OrderDetailsViewModel:ViewModel() {
   private val orderDetails: MutableLiveData<OrderDetailsResponse> = MutableLiveData()
    fun orderDetails(): MutableLiveData<OrderDetailsResponse> = orderDetails

     fun orderDetails(accessToken: String,order_id:String){

         ApiClient().apiServices.orderDetails(accessToken,order_id).subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeBy (
                    onNext = {
                        orderDetails.postValue(it)
                    },onError = {
                     orderDetails.postValue(null)

                 },onComplete = {

                 })
    }

}