package com.example.neostoreapp.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class BaseActivity : AppCompatActivity(),BaseView {
    abstract val layout:Int
    abstract val getPresenter:BasePresenter
    abstract fun init()
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(layout)
       init()
    }
    override fun onStart() {
        super.onStart()
        getPresenter.start()
    }

    override fun onStop() {
        super.onStop()
        getPresenter.stop()
    }
    fun showToast(message:String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }
      override fun showError()
    {
        Toast.makeText(this,"This is warning for user",Toast.LENGTH_SHORT).show()
    }
    override fun showLoading()
    {

    }
    override fun hideLoading()
    {

    }
    override fun logout()
    {

    }
}