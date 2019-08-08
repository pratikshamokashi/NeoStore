package com.example.neostoreapp.ui.productlisting

import android.content.Intent
import android.view.View
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.row_layout.*
import kotlinx.android.synthetic.main.toolbar.*
import java.lang.Integer.parseInt

class ProductActivity : BaseActivity(),ProductContract.ProductView{

    override val layout= R.layout.activity_product

    var  presenter = ProductPresenter(this,this)
    val getPresenter: BasePresenter
        get() = presenter
    override fun init() {
        val productId=intent.extras.get("product_id").toString()
        menu_img.visibility= View.GONE
        ab_back_white.setOnClickListener {
            finish()
        }
        presenter.productlisting(productId,"10","1")
        presenter.setAdapter(my_recycler_view)
        when(parseInt(productId)){
             1 -> txt_neostore1.setText("Tables")
             2 -> txt_neostore1.setText("Chairs")
             3 -> txt_neostore1.setText("Sofas")
             4 -> txt_neostore1.setText("Cupboards")
        }
    }
    override fun showEmailError() {
    }

    override fun showPasswordError() {
    }
    override fun showError() {
    }

    override fun failureProduct(errorMsg: String) {
        showToast(errorMsg)
    }

    override fun sucessProduct(res: ProductResponse?) {
        showToast("sucessful....!"+res)
        presenter.passDataToAdapter(res?.data)
    }

}



