package com.example.neostoreapp.ui.productdetails

import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.base.BaseView
import retrofit2.Response

interface ProductDetailContract {
    interface ProductDetailsView:BaseView{
        fun sucessProductDetails(response: ProductDetailsResponse?)
        fun failureProductDetails(error:String)
        fun sucessRating(response: RatingResponse)

    }
    interface ProductDetailsPresenter:BasePresenter
    {
        fun productDetails(product_id:String)
        fun setRating(product_id:String,rating:String)
    }
}