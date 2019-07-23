package com.example.neostoreapp.ui.productdetails

import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.base.BaseView

interface ProductDetailContract {
    interface ProductDetailsView:BaseView{
        fun sucessProductDetails(response: ProductDetailsResponse?)
        fun failureProductDetails(error:String)

    }
    interface ProductDetailsPresenter:BasePresenter
    {
        fun productDetails(product_id:String)
    }
}