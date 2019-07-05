package com.example.neostoreapp.services


import com.example.neostoreapp.ui.login.LoginResponse
import com.example.neostoreapp.ui.productlisting.ProductResponse
import com.example.neostoreapp.ui.registration.RegisterResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

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

    @GET("products/getList")
    fun productlist(@Query("product_category_id")product_category_id:String,
                    @Query("limit")limit:String,
                    @Query("page")page:String):Call<ProductResponse>

}

