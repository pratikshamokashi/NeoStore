package com.example.neostoreapp.ui.mycartlisting

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Product(

	@field:SerializedName("product_images")
	val productImages: String? = null,

	@field:SerializedName("cost")
	val cost: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("sub_total")
	val subTotal: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("product_category")
	val productCategory: String? = null
)