package com.example.neostoreapp.ui.mycartlisting

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class MyCartResponse(

	@field:SerializedName("total")
	val total: Double? = null,

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("status")
	val status: Int? = null
)