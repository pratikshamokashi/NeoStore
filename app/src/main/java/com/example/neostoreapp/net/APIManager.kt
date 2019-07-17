package com.example.neostoreapp.net

import com.example.neostoreapp.services.ApiClient
import com.example.neostoreapp.ui.accountdetails.Response
import com.example.neostoreapp.ui.base.MyApp
import com.example.neostoreapp.ui.editprofile.EditProfileResponse
import com.example.neostoreapp.ui.productlisting.ProductResponse
import com.example.neostoreapp.ui.registration.RegisterResponse
import com.example.neostoreapp.ui.resetpassword.ResetResponse
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
    fun changePassword(old_password:String,password: String,confirm_password: String,callback: Callback<ResetResponse>) {
        val apiClient=ApiClient.instance.apiServices.changePassword(MyApp.instance.acess_token,old_password,password,confirm_password)
        apiClient.enqueue(callback)
    }
    fun getAccountDetails(callback: Callback<Response>) {
        val apiClient=ApiClient.instance.apiServices.getAccountDetails(MyApp.instance.acess_token)
        apiClient.enqueue(callback)
    }
    fun editProfile(email: String,dob:String,phoneNumber: String,profile_pic:String,callback: Callback<EditProfileResponse>){
        val apiClient=ApiClient.instance.apiServices.editProfile(MyApp.instance.acess_token,email,dob,phoneNumber,profile_pic)
        apiClient.enqueue(callback)

    }
}

