package com.example.neostoreapp.ui.resetpassword

import com.google.gson.annotations.SerializedName

 class ResetResponse(
    @field:SerializedName("data")
    val data: List<Any?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null,

    @field:SerializedName("user_msg")
    val userMsg: String? = null
)
