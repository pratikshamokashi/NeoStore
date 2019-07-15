package com.example.neostoreapp.ui.base

import android.app.Application
import android.util.Log

class MyApp: Application() {
   lateinit var acess_token:String
    override fun onCreate() {
        super.onCreate()
        Log.d("tag","myapp")
        instance = this
    }

    companion object {
      lateinit var instance: MyApp

    }
}