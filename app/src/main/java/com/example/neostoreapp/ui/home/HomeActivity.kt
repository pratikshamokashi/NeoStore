package com.example.neostoreapp.ui.home

import android.content.Intent
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.login.LoginContract
import com.example.neostoreapp.ui.login.LoginPresenter
import com.example.neostoreapp.ui.login.LoginResponse
import com.example.neostoreapp.ui.registration.RegisterActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity: BaseActivity(), LoginContract.LoginView  {
    override var layout= R.layout.activity_home
    var  presnter = LoginPresenter(this)
    override val getPresenter: BasePresenter
     get() = presnter

    internal lateinit var viewPager: ViewPager
      //  var search = findViewById(R.id.search_img) as ImageView
    override fun init() {
      ab_back_white.visibility=View.GONE
        viewPager=findViewById<View>(R.id.viewPager) as ViewPager
        val adapter =ViewPageAdapter(this)
        viewPager.adapter=adapter
/*
    menu_img.setOnClickListener(){
          Toast.makeText(this,"menu clicked",Toast.LENGTH_SHORT).show()

      }
      search_img.setOnClickListener(View.OnClickListener {
          Toast.makeText(this,"search clicked",Toast.LENGTH_SHORT).show()

      })*/
    }


    override fun loginFailure(errorMsg: String) {

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