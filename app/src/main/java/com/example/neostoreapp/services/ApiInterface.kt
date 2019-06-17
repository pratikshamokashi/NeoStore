package com.example.neostoreapp.services

import com.example.neostoreapp.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("users/login")
    fun login(@Field("email")email:String,
              @Field("password")password:String): Call<LoginResponse>


}

