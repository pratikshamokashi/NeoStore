package com.example.neostoreapp.activity

import android.content.Intent
import com.example.neostoreapp.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {
    override var value = R.layout.activity_register
    override fun init() {
        btn_register.setOnClickListener {
            // getApiCall()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}

/*    fun getApiCall() {
        val firstname= et_firstName.text.toString()
        val lastname:String= et_lastName.text.toString()
        val email:String= et_registerEmail.text.toString()
        val password:String= et_registerPassword.text.toString()
        val confirmpassword:String= et_confirm_password.text.toString()
        val gender:String= rb_male.text.toString()
        val phoneno:String= et_phn_no.text.toString()*/

       // val destinationservice = APIService.instance.apiServices.register(firstname,lastname,email,password
      //  ,confirmpassword,gender,phoneno)
      //  destinationservice.enqueue(object : Callback<LoginResponse> {
           // override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) =
              /*  if (response != null) {
                    // if(response.isSuccessful){
                    val res = response.body()
                    if (res != null) {
                        // finish()
                        showToast(res?.message)
                        val it = Intent(this@RegisterActivity, HomeActivity::class.java)
                        startActivity(it)
                    } else {
                        showToast(message = "failed")
                    }
                    *//*}else{
             showToast("login is fail")
         }*//*
                } else {
                    showToast("Fail")
                }

            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                showToast("Failed to login")
            }
        })
    }*/
//}



