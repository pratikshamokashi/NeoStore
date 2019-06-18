package com.example.neostoreapp.ui.registration

import android.content.Intent
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.home.HomeActivity
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.login.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(),RegisterContract.RegisterView {
    override var layout= R.layout.activity_register
    override fun init() {
        btn_register.setOnClickListener {
            lateinit var registerpresenter: RegisterPresenter
            val firstName =et_firstName.text.toString()
            val lastName =et_lastName.text.toString()
            val email = et_email.text.toString()
            val password = et_password.text.toString()
            val confirmPassword= et_confirm_password.text.toString()
            val gender=rb_male.text.toString()
            val phoneNumber=et_phn_no.text.toString()

            registerpresenter = RegisterPresenter(this)
            registerpresenter.register(firstName,lastName,email, password,confirmPassword,gender,phoneNumber)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
    override var getPresenter: BasePresenter
        get() = presenter
        set(value) {}
    var presenter= RegisterPresenter(this)

    override fun registerValidation() {

    }

    override fun registerFailure() {
        showToast("Failed to register")
    }

    override fun registerSucess(res: RegisterResponse) {
        showToast(res.message)

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



