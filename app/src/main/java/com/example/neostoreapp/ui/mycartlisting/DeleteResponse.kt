package com.example.neostoreapp.ui.mycartlisting

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class DeleteResponse(

	@field:SerializedName("total_carts")
	val totalCarts: Int? = null,

	@field:SerializedName("data")
	val data: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("user_msg")
	val userMsg: String? = null
)