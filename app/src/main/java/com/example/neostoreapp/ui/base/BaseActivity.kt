package com.example.neostoreapp.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.toolbar.*
import android.view.Gravity
import com.example.neostoreapp.R


abstract class BaseActivity : AppCompatActivity(),BaseView {

    abstract val layout:Int
    abstract val getPresenter:BasePresenter
    abstract fun init()
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_base)

        //inflated view pass from child activity
        var inflater = LayoutInflater.from(this)
        var view = inflater.inflate(layout, null);
        container.addView(view)

       init()

        menu_img.setOnClickListener(View.OnClickListener {
            drawer_layout.openDrawer(Gravity.LEFT)
        })
    }
    override fun onStart() {
        super.onStart()
        getPresenter.start()
    }

    override fun onStop() {
        super.onStop()
        getPresenter.stop()
    }
    fun showToast(message: String?){
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