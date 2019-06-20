package com.example.neostoreapp.ui.registration

import android.content.Intent
import android.util.Log
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.home.HomeActivity
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.login.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(),RegisterContract.RegisterView {
    override var layout= R.layout.activity_register
    override var getPresenter: BasePresenter
        get() = presenter
        set(value) {}
    var presenter= RegisterPresenter(this)


    override fun init() {
        btn_register.setOnClickListener {
            lateinit var registerpresenter: RegisterPresenter
            val first_name =et_firstName.text.toString()
            val last_name =et_lastName.text.toString()
            val email = et_registerEmail.text.toString()
            val password = et_registerPassword.text.toString()
            val confirm_password= et_confirm_password.text.toString()
            var gender:String
            if(rb_male.isChecked)
            {
                gender="M"
            }else{
                gender="F"
            }
            val phone_no=et_phn_no.text.toString()
            val isValidate: Boolean = presenter.registerValidation(first_name,last_name,email,password,
                                                                    confirm_password, gender, phone_no)

            if(isValidate)
            {
               presenter.register(first_name,last_name, email, password, confirm_password, gender, phone_no)
            }

            registerpresenter = RegisterPresenter(this)
            registerpresenter.register(first_name,last_name,email, password,confirm_password,gender,phone_no)

        }
    }
    override fun showFirstNameError() {
        et_firstName.error="First Name is required"
        et_firstName.requestFocus()        }

    override fun showLastNameEror() {
        et_lastName.error="Last Name is required"
        et_lastName.requestFocus()        }
    override fun showEmailError() {
        et_registerEmail.error="Email is required"
        et_registerEmail.requestFocus()
    }

    override fun showPasswordError() {
        et_registerPassword.error="Password is required"
        et_registerPassword.requestFocus()        }

    override fun showConfirmPasswordError() {
        et_confirm_password.error="Confirm Password is required"
        et_confirm_password.requestFocus()        }

    override fun showGenderError() {
        rb_female.error="Gender is required"
        rb_female.requestFocus()        }

    override fun showPhoneNumberError() {
        et_phn_no.error="Phone Number is required"
        et_phn_no.requestFocus()        }


    override fun registerSucess(res: RegisterResponse?) {
        showToast(res?.message!!)
        et_firstName.setText("")
        et_lastName.setText("")
        et_registerEmail.setText("")
        et_registerPassword.setText("")
        et_confirm_password.setText("")
        et_phn_no.setText("")
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun registerFailure() {
        showToast(" Registration Unsucessfull..!")
    }
}

