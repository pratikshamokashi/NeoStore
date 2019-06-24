package com.example.neostoreapp.services


import com.example.neostoreapp.ui.login.LoginResponse
import com.example.neostoreapp.ui.registration.RegisterResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("users/login")
    fun login(@Field("email")email:String,
              @Field("password")password:String): Observable<LoginResponse>
    @FormUrlEncoded
    @POST("users/register")
    fun register(@Field("first_name")first_name:String,
                 @Field("last_name")last_name:String,
                 @Field("email")email:String,
                 @Field("password")password:String,
                 @Field("confirm_password")confirm_password:String,
                 @Field("gender")gender:String,
                 @Field("phone_no")phone_no:String):Call<RegisterResponse>

}

