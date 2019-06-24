package com.example.neostoreapp.net

import com.example.neostoreapp.services.ApiClient
import com.example.neostoreapp.ui.login.LoginResponse
import com.example.neostoreapp.ui.registration.RegisterResponse
import retrofit2.Callback

class APIManager {

   /* fun login(email:String,password:String,callback: Callback<LoginResponse>){
        val apiClient= ApiClient.instance.apiServices.login(email, password)
        //apiClient.registerObserver(LoginResponse)
          apiClient.enqueue(callback)
    }*/
    fun register(firstName:String,lastName:String,email:String,
                 password:String,confirmPassword:String,gender:String,
                 phoneNumber:String,callback:Callback<RegisterResponse>) {
        val apiClient = ApiClient.instance.apiServices.register(
            firstName,
            lastName,
            email,
            password,
            confirmPassword,
            gender,
            phoneNumber
        )
       apiClient.enqueue(callback)

    }
}