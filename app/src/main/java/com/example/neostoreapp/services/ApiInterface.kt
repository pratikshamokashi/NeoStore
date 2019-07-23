package com.example.neostoreapp.services


import com.example.neostoreapp.ui.accountdetails.Response
import com.example.neostoreapp.ui.editprofile.EditProfileResponse
import com.example.neostoreapp.ui.login.LoginResponse
import com.example.neostoreapp.ui.productdetails.ProductDetailsResponse
import com.example.neostoreapp.ui.productlisting.ProductResponse
import com.example.neostoreapp.ui.registration.RegisterResponse
import com.example.neostoreapp.ui.resetpassword.ResetResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface ApiInterface {
    @FormUrlEncoded
    @POST("users/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Observable<LoginResponse>

    @FormUrlEncoded
    @POST("users/register")
    fun register(
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirm_password") confirm_password: String,
        @Field("gender") gender: String,
        @Field("phone_no") phone_no: String
    ): Call<RegisterResponse>

    @GET("products/getList")
    fun productlist(
        @Query("product_category_id") product_category_id: String,
        @Query("limit") limit: String,
        @Query("page") page: String
    ): Call<ProductResponse>

    @FormUrlEncoded
    @POST("users/change")
    fun changePassword(
            @Header("access_token") token: String,
            @Field("old_password") old_password: String,
            @Field("password") password: String,
            @Field("confirm_password") confirm_password: String
           // accessToken: String
    ): Call<ResetResponse>

    @GET("users/getUserData")
    fun getAccountDetails(
        @Header("access_token") token: String
    ):Call<Response>

    @FormUrlEncoded
    @POST("users/update")
    fun editProfile(
            @Header("access_token") token: String,
            @Field("first_name") first_name: String,
            @Field("last_name") last_name: String,
            @Field("email") email: String,
            @Field("dob") dob: String,
            @Field("phone_no") phone_no: String,
            @Field("profile_pic") profile_pic: String
    ): Call<EditProfileResponse>

    @GET("products/getDetail")
    fun productDetails(
            @Query("product_id") product_id: String):Call<ProductDetailsResponse>

}

