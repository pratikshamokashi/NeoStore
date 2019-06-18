package com.example.neostoreapp.ui.registration

import android.text.TextUtils
import com.example.neostoreapp.services.ApiClient
import retrofit2.Call
import retrofit2.Response
import com.example.neostoreapp.ui.registration.RegisterResponse as RegisterResponse

class RegisterPresenter():RegisterContract.Presenter {
    lateinit var mView: RegisterContract.RegisterView
    constructor(registerView: RegisterContract.RegisterView): this() {
        this.mView=registerView
    }
    override fun start() {
    }

    override fun stop() {

    }

    override fun register(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        confirmPassword: String,
        gender: String,
        phoneNumber: String
    ) {
            if(TextUtils.isEmpty(firstName)|| TextUtils.isEmpty(lastName)|| TextUtils.isEmpty(email)||TextUtils.isEmpty(password)
                || TextUtils.isEmpty(confirmPassword)|| TextUtils.isEmpty(gender)|| TextUtils.isEmpty(phoneNumber))
            {
                mView.registerValidation()
            }else
            {
                val apiClient = ApiClient.instance.apiServices.register(firstName,lastName,email,password,confirmPassword,gender,phoneNumber)
                apiClient.enqueue(object:retrofit2.Callback<RegisterResponse> {
                        override fun onFailure(call: Call<RegisterResponse>?, t: Throwable?) {
                    mView.registerFailure()
                }
                        override fun onResponse(call: Call<RegisterResponse>?, response: Response<RegisterResponse>?) {
                            if (response != null) {
                                val result = response.body()
                                if (result != null) {
                                    mView.registerSucess(result)
                                } else {
                                    mView.registerFailure()
                                }
                            }
                        }
                })
    }

}
}