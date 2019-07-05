package com.example.neostoreapp.ui.productlisting

import com.example.neostoreapp.ui.base.BasePresenter
import com.example.neostoreapp.ui.base.BaseView
import com.example.neostoreapp.ui.registration.RegisterResponse

interface ProductContract {
    interface ProductView : BaseView {
        fun showEmailError()
        fun showPasswordError()
        fun failureProduct(errorMsg: String)
        fun sucessProduct(res:ProductResponse?)

    }
    interface Presenter:BasePresenter{
        fun productlisting(product_category_id:String,limit:String,page:String)
    }
}