package com.example.neostoreapp.ui.productlisting

import android.view.View
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.toolbar.*

class ProductActivity : BaseActivity(),ProductContract.ProductView{
    override fun failureProduct(errorMsg: String) {
        showToast(errorMsg)
    }

    override fun sucessProduct(res: ProductResponse?) {
        showToast("sucessful....!"+res)

        presenter.passDataToAdapter(res?.data)
    }
    override fun showEmailError() {
    }

    override fun showPasswordError() {
    }

    override val layout= R.layout.activity_product

    var  presenter = ProductPresenter(this,this)
    override val getPresenter: BasePresenter
        get() = presenter
    override fun init() {
        txt_neostore1.setText("Tables")
        menu_img.visibility= View.GONE
        ab_back_white.setOnClickListener {
            finish()
        }
        //Log.d("TAG","Init method:"+)
        presenter.productlisting(intent.extras.get("product_id").toString(),"10","1")
        presenter.setAdapter(my_recycler_view)


    }

    fun setData(){}


}
