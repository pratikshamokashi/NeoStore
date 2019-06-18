package com.example.neostoreapp.services

import com.example.neostoreapp.ui.login.LoginResponse
import com.example.neostoreapp.ui.registration.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("users/login")
    fun login(@Field("email")email:String,
              @Field("password")password:String): Call<LoginResponse>
    @FormUrlEncoded
    @POST("users/register")
    fun register(@Field("firstName")firstName:String,
                 @Field("lastName")lastName:String,
                 @Field("email")email:String,
                 @Field("password")password:String,
                 @Field("confirmPassword")confirmPassword:String,
                 @Field("gender")gender:String,
                 @Field("phoneNumber")phoneNumber:String):Call<RegisterResponse>

}

