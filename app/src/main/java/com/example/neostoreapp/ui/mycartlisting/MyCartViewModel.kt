package com.example.neostoreapp.ui.mycartlisting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import com.example.neostoreapp.services.ApiClient
import com.example.neostoreapp.ui.accountdetails.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MyCartViewModel:ViewModel() {
    private val mycartDetails: MutableLiveData<MyCartResponse> = MutableLiveData()
    fun mycartList(): MutableLiveData<MyCartResponse> = mycartDetails

    fun mycartList(accessToken: String){
        Log.d("tag","sucess11")
        ApiClient().apiServices.mycartList(accessToken).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            Log.d("tag","sucess12")
                            if (it != null) {
                                mycartDetails.postValue(it)
                            }
                        },onError = {
                    Log.d("tag","sucess13")

                    mycartDetails.postValue(null)
                },
                        onComplete = {

                        }

                )
    }

    }

