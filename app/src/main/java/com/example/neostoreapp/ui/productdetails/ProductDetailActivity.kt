package com.example.neostoreapp.ui.productdetails

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.base.BasePresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.activity_product_detail.btn_buy
import kotlinx.android.synthetic.main.activity_product_detail.img_product
import kotlinx.android.synthetic.main.activity_product_detail.txt_productname
import kotlinx.android.synthetic.main.dialog_fragment.*
import kotlinx.android.synthetic.main.toolbar.*

class ProductDetailActivity : BaseActivity(),ProductDetailContract.ProductDetailsView, ProductAdapter.onItemClick{

    override val layout: Int=R.layout.activity_product_detail
    var presenter =ProductDetailsPresenter(this,this)
    override val getPresenter: BasePresenter
        get() =presenter

   private var list:List<ProductImagesItem>? =null
    lateinit var myAdapter:ProductAdapter
    private var mResponse: ProductDetailsResponse? = null
    var selectedImage:String = ""

    override fun init() {
        menu_img.visibility=View.GONE
        ab_back_white.setOnClickListener {
            finish()
        }
        if (intent.extras != null)
            presenter.productDetails(intent.extras.get("id").toString())
            img_recycler_view.layoutManager =LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false)
       setAdapter(img_recycler_view)

        when(Integer.parseInt(intent.extras.get("product_id").toString())){
            1 -> txt_productcategory.setText("Category - Tables")
            2->  txt_productcategory.setText("Category - Chairs")
            3 -> txt_productcategory.setText("Category - Sofas")
            4 -> txt_productcategory.setText("Category - Cupboards")
        }
        btn_buy.setOnClickListener {
            val fm = supportFragmentManager
            val dialogFragment = ProductDialogFragment()
            var  bundle = Bundle()
            bundle.putString("title", mResponse?.data?.name);
            bundle.putString("image", selectedImage)
            dialogFragment.setArguments(bundle)
            dialogFragment.show(fm, "ProductDialogFragment")
        }
        btn_rate.setOnClickListener {
            val fm = supportFragmentManager
            val dialogFragment = RatingdialogFragment()
            var  bundle = Bundle()
            bundle.putString("title", mResponse?.data?.name);
            bundle.putString("image", selectedImage)
            dialogFragment.setArguments(bundle)
            dialogFragment.show(fm, "RatingdialogFragment")
        }
    }

    fun setAdapter(mRecyclerView: RecyclerView)
    {
        myAdapter= ProductAdapter(list,this,this)
        mRecyclerView.adapter=myAdapter
    }

    fun setDatatoAdapter(data: List<ProductImagesItem>){
        myAdapter.setToAdapter(data)
        myAdapter.notifyDataSetChanged()
    }

    fun passDatatoAdapter(data: List<ProductImagesItem>)
    {
        setDatatoAdapter(data)
    }

    override fun onClicked(position: Int) {
       // Log.d("tag1","onc: "+list?.get(position)?.image)
        Picasso.with(this).load(list?.get(position)?.image).into(img_product)
        selectedImage = list?.get(position)?.image!!
    }
    override fun sucessProductDetails(response: ProductDetailsResponse?) {
        mResponse = response
        list = response?.data?.productImages as List<ProductImagesItem>
        Log.d("tag","onsucess2")
        passDatatoAdapter(list!!)
        txt_productname.text = response.data.name
        txt_neostore1.setText(""+txt_productname.text)
        txt_neostore1.textSize= 25F
        txt_productcost.setText("Rs "+response.data.cost)
        txt_producttype.text=response.data.producer
        rating_bar_productdetails.rating= response.data.rating!!.toFloat()
        txt_description.setText("Description: \n"+response.data.description  )
        Log.d("tag","img: "+response.data?.productImages.get(0).image)
        Picasso.with(this).load(response.data?.productImages.get(0).image).into(img_product)
    }

    override fun failureProductDetails(error: String) {

    }

}

/*private fun Picasso.load(get: ProductImagesItem?) {

}*/
