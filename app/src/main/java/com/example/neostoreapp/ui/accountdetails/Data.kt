package com.example.neostoreapp.ui.accountdetails

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Data(

	@field:SerializedName("total_carts")
	val totalCarts: Int? = null,

	@field:SerializedName("product_categories")
	val productCategories: List<ProductCategoriesItem?>? = null,

	@field:SerializedName("user_data")
	val userData: UserData? = null,

	@field:SerializedName("total_orders")
	val totalOrders: Int? = null
)