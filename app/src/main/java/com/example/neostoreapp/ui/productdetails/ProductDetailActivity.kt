package com.example.neostoreapp.ui.productdetails

import android.content.SharedPreferences
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.activity_product_detail.btn_buy
import kotlinx.android.synthetic.main.activity_product_detail.img_product
import kotlinx.android.synthetic.main.activity_product_detail.txt_productname
import kotlinx.android.synthetic.main.dialog_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import androidx.core.view.MenuItemCompat
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_base.*


class ProductDetailActivity : BaseActivity(), ProductDetailContract.ProductDetailsView, ProductAdapter.onItemClick,
        RatingdialogFragment.DialogRatingContract,ProductDialogFragment.DialogSetQuantityContract {

    override val layout: Int = R.layout.activity_product_detail
    var presenter = ProductDetailsPresenter(this, this)
    // override val getPresenter: BasePresenter
    //get() =presenter
    lateinit var sharedPreferences: SharedPreferences

    private var list: List<ProductImagesItemModel>? = null
    lateinit var myAdapter: ProductAdapter
    private var mResponse: ProductDetailsResponse? = null
    var selectedImage: String = ""
    var position: Int = 0

    override fun init() {

        position = intent.extras.getInt("position")
        sharedPreferences = getSharedPreferences("myPref", 0)
        val access_token:String=sharedPreferences.getString("access_token",null)
        menu_img.visibility = View.GONE
        ab_back_white.setOnClickListener {
            finish()
        }
        if (intent.extras != null)
            presenter.productDetails(intent.extras.get("id").toString())
            img_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                    false)
            setAdapter(img_recycler_view)

        when (Integer.parseInt(intent.extras.get("product_id").toString())) {
            1 -> txt_productcategory.setText("Category - Tables")
            2 -> txt_productcategory.setText("Category - Chairs")
            3 -> txt_productcategory.setText("Category - Sofas")
            4 -> txt_productcategory.setText("Category - Cupboards")
        }
        btn_buy.setOnClickListener {
            Log.d("title", "Title: " + mResponse?.data?.name)
            val fm = supportFragmentManager
            val dialogFragment = ProductDialogFragment()
            val bundle = Bundle()
            bundle.putString("title", mResponse?.data?.name)
            bundle.putString("image", selectedImage)
            bundle.putString("quantity", mResponse?.data?.viewCount.toString())
            bundle.putString("id",intent.extras.get("id").toString())
            bundle.putString("access_token",access_token)
            dialogFragment.setArguments(bundle)
            dialogFragment.show(fm, "ProductDialogFragment")
        }
        btn_rate.setOnClickListener {

            val fm = supportFragmentManager
            val dialogFragment = RatingdialogFragment()
            val bundle = Bundle()
            bundle.putString("title", mResponse?.data?.name);
            bundle.putString("img", selectedImage)
            bundle.putFloat("rating", mResponse?.data?.rating?.toFloat()!!)
            bundle.putString("id", intent.extras.get("id").toString())
            dialogFragment.setArguments(bundle)
            dialogFragment.show(fm, "RatingdialogFragment")
        }
    }

    fun setAdapter(mRecyclerView:RecyclerView) {
        myAdapter = ProductAdapter(list, this, this)
        mRecyclerView.adapter = myAdapter
    }

    fun setDatatoAdapter(data: List<ProductImagesItemModel>) {
        myAdapter.setToAdapter(data)
        myAdapter.notifyDataSetChanged()
    }

    fun passDatatoAdapter(data: List<ProductImagesItemModel>) {
        setDatatoAdapter(data)
    }

    override fun onClicked(position: Int) {
        // Log.d("tag1","onc: "+list?.get(position)?.image)
        Picasso.with(this).load(list?.get(position)?.image).into(img_product)
        selectedImage = list?.get(position)?.image!!
    }
    override fun sucessProductDetails(response: ProductDetailsResponse?) {
        mResponse = response
        list = response?.data?.productImages as List<ProductImagesItemModel>
        Log.d("PRA", "IMage list:" + list)
        passDatatoAdapter(list!!)
        txt_productname.text = response.data.name
        txt_neostore1.setText("" + txt_productname.text)
        txt_neostore1.textSize = 25F
        txt_productcost.setText("    Rs. " + response.data.cost)
        txt_producttype.setText(response.data.producer)
        rating_bar_productdetails.rating = response.data.rating!!.toFloat()
        txt_description.setText("Description: \n" + response.data.description)
        if (list != null) {
            Picasso.with(this).load(list?.get(0)?.image).into(img_product)

        }
        selectedImage = list?.get(0)?.image.toString()

    }

    override fun applyRating(product_id: String, rating: String) {
        Log.d("tag", "apply" + rating)
        presenter.setRating(product_id, rating)
    }

    override fun sucessRating(response: RatingResponse) {
        rating_bar_productdetails.rating = response.ratingData?.rating?.toFloat()!!
    }

    override fun setQuantity(access_token: String, product_id: String, quantity: String) {
        Log.d("tag","Quqntity1")
        presenter.setQuantity(access_token, product_id, quantity)

    }
    override fun sucessToSetQuantity(response: QuantityResponse) {
        Log.d("tag","Quqntity"+response.totalCarts)
     //   mycart.setText(response.totalCarts.toString())
         showToast(response.message)
    }
    override fun failureProductDetails(error: String) {

    }

}

/*private fun Picasso.load(get: ProductImagesItemModel?) {

}*/
