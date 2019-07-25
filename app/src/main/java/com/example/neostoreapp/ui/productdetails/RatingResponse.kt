package com.example.neostoreapp.ui.productdetails

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class RatingResponse(

	@field:SerializedName("data")
	val ratingData: RatingData? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("user_msg")
	val userMsg: String? = null
)