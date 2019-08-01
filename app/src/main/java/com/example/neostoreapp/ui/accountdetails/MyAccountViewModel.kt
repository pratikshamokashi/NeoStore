package com.example.neostoreapp.ui.accountdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import com.example.neostoreapp.services.ApiClient
import com.example.neostoreapp.ui.forgotpassword.MyAccountContract
import com.example.neostoreapp.ui.resetpassword.Reset1Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit

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
