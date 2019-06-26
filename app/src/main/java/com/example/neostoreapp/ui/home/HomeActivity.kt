package com.example.neostoreapp.ui.home

import android.support.v4.view.ViewPager
import android.view.View
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.login.LoginContract
import com.example.neostoreapp.ui.login.LoginPresenter
import com.example.neostoreapp.ui.login.LoginResponse

class HomeActivity: BaseActivity(), LoginContract.LoginView  {
    override var layout= R.layout.activity_home
    var  presnter = LoginPresenter(this)
    override val getPresenter: BasePresenter
     get() = presnter

    internal lateinit var viewPager: ViewPager

    override fun init() {
        viewPager=findViewById<View>(R.id.viewPager) as ViewPager
        val adapter =ViewPageAdapter(this)
        viewPager.adapter=adapter
    }


    override fun loginFailure(s: String) {

    }

    override fun showEmailError() {

    }

    override fun showPasswordError() {

    }



    override fun loginSucess(res: LoginResponse?) {

    }


    /*override var getPresenter: BasePresenter
        get() = getPresenter
        set(value) {}*/
    /*override var layout = R.layout.activity_home
    override fun init() {
       // setToolbar("home")*/
//}

}