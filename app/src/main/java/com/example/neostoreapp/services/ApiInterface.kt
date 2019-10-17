package com.example.neostoreapp.services


import com.example.neostoreapp.ui.accountdetails.Response
import com.example.neostoreapp.ui.address.AddressEntity
import com.example.neostoreapp.ui.address.OrderResponse
import com.example.neostoreapp.ui.editprofile.EditProfileResponse
import com.example.neostoreapp.ui.forgetpassword.ForgotPasswordResponse
import com.example.neostoreapp.ui.resetpassword.Reset1Response
import com.example.neostoreapp.ui.login.LoginResponse
import com.example.neostoreapp.ui.mycartlisting.DeleteResponse
import com.example.neostoreapp.ui.mycartlisting.MyCartResponse
import com.example.neostoreapp.ui.myorder.MyOrderResponse
import com.example.neostoreapp.ui.orderdetails.OrderDetailsResponse
import com.example.neostoreapp.ui.productdetails.ProductDetailsResponse
import com.example.neostoreapp.ui.productdetails.QuantityResponse
import com.example.neostoreapp.ui.productdetails.RatingResponse
import com.example.neostoreapp.ui.productlisting.ProductResponse
import com.example.neostoreapp.ui.registration.RegisterResponse
import io.reactivex.Observable
import retrofit2.Call
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

    /*@FormUrlEncoded
    @POST("users/change")
    fun changePassword(
            @Header("access_token") token: String,
            @Field("old_password") old_password: String,
            @Field("password") password: String,
            @Field("confirm_password") confirm_password: String
           // accessToken: String
    ): Call<ResetResponse>*/

    @FormUrlEncoded
    @POST("users/change")
    fun resetPassword(
            @Header("access_token") token: String,
            @Field("old_password") old_password: String,
            @Field("password") password: String,
            @Field("confirm_password") confirm_password: String
    ):Observable<Reset1Response>


    @GET("users/getUserData")
    fun getAccountDetails(
        @Header("access_token") token: String
    ):Observable<Response>

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
            @Query("product_id") product_id: String
    ):Call<ProductDetailsResponse>

    @FormUrlEncoded
    @POST("products/setRating")
    fun setRating(
            @Field("product_id")product_id:String,
            @Field("rating")rating:String
    ):Call<RatingResponse>

    @FormUrlEncoded
    @POST("addToCart")
    fun setQuantity(
            @Header("access_token")access_token:String,
            @Field("product_id")product_id:String,
            @Field("quantity")quantity:String
    ):Call<QuantityResponse>

    @GET("cart")
    fun mycartList(
            @Header("access_token")access_token:String
    ):Observable<MyCartResponse>

    @FormUrlEncoded
    @POST("order")
    fun orderPlaced(
            @Header("access_token")access_token: String,
            @Field("address")address: String
            ):Observable<OrderResponse>

    @GET("orderList")
    fun myorderList(
            @Header("access_token")access_token:String
    ):Observable<MyOrderResponse>

    @GET("orderDetail")
    fun orderDetails(@Header("access_token")access_token:String,
                       @Query("order_id")order_id:String
    ):Observable<OrderDetailsResponse>

    @FormUrlEncoded
    @POST("deleteCart")
    fun deleteItem(@Header("access_token")access_token:String,
                   @Field("product_id")product_id: String
    ):Observable<DeleteResponse>

    @FormUrlEncoded
    @POST("users/forgot")
    fun forgotPassword(@Field("email")email:String):Observable<ForgotPasswordResponse>

}

