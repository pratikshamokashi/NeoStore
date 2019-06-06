package com.example.neostoreapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

   abstract var value:Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(value)
       getvalue()

    }

 abstract fun getvalue()
}