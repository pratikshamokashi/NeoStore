package com.example.neostoreapp.net

import com.example.neostoreapp.services.ApiClient
import com.example.neostoreapp.ui.accountdetails.Response
import com.example.neostoreapp.ui.editprofile.EditProfileResponse
import com.example.neostoreapp.ui.productdetails.ProductDetailsResponse
import com.example.neostoreapp.ui.productdetails.QuantityResponse
import com.example.neostoreapp.ui.productdetails.RatingResponse
import com.example.neostoreapp.ui.productlisting.ProductResponse
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
    fun productlist(product_category_id:String,limit:String,page:String,callback: Callback<ProductResponse>){
        val apiClient=ApiClient.instance.apiServices.productlist(product_category_id,limit,page)

        apiClient.enqueue(callback)
    }
   /* fun changePassword(accessToken: String?, old_password:String, password: String, confirm_password:String, callback: Callback<ResetResponse>) {
        val apiClient=ApiClient.instance.apiServices.changePassword(accessToken!!,old_password,password,confirm_password)
        apiClient.enqueue(callback)
    }*/
   /* fun getAccountDetails(callback: Callback<Response>, accessToken: String?) {
        val apiClient=ApiClient.instance.apiServices.getAccountDetails(accessToken!!)
        apiClient.enqueue(callback)
    }*/
    fun editProfile(accessToken: String?,firstName:String,lastName:String,email:String,dob:String,phoneNumber:String,profile_pic:String,callback: Callback<EditProfileResponse>){
        val apiClient=ApiClient.instance.apiServices.editProfile(accessToken!!,firstName,lastName,email,dob,phoneNumber,profile_pic)
        apiClient.enqueue(callback)
    }
    fun productDetails(product_id: String, callback:Callback<ProductDetailsResponse>)    {
        val apiClient=ApiClient.instance.apiServices.productDetails(product_id)
        apiClient.enqueue(callback)
    }
    fun setRating(product_id:String,rating:String,callback: Callback<RatingResponse>){
        val apiClient = ApiClient.instance.apiServices.setRating(product_id,rating)
        apiClient.enqueue(callback)
    }
    fun setQuantity(access_token:String,product_id:String,quantity:String,callback:Callback<QuantityResponse>){
        val apiClient=ApiClient.instance.apiServices.setQuantity(access_token,product_id,quantity)
        apiClient.enqueue(callback)

    }
}

