package com.example.neostoreapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

abstract class BaseActivity : AppCompatActivity() {
   abstract var value:Int
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(value)
       init()
    }
    /*fun setToolbar(title:String)
    {
        setSupportActionBar(id_toolbar)
        setToolbar(title)
    }*/
    abstract fun init()
}