package com.example.neostoreapp.ui.productdetails

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import com.example.neostoreapp.ui.productdetails.ProductAdapter.onItemClick
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit

class ProductDetailsPresenter(productView:ProductDetailContract.ProductDetailsView,context: Context):ProductDetailContract.ProductDetailsPresenter {


    var mView:ProductDetailContract.ProductDetailsView?=null
    private var context:Context
  //  lateinit var myAdapter:ProductAdapter

    private var data:List<ProductImagesItem>? = null

    init {
        this.context=context
        this.mView=productView

        }

    override fun productDetails(product_id: String) {
        APIManager().productDetails(product_id,object :APICallback<ProductDetailsResponse>()
        {
            override fun onSucess(code: Int?, response: ProductDetailsResponse?) {
                mView?.sucessProductDetails(response)
                Log.d("tag","onsucess"+mView)
            }

            override fun onFail(code: Int?, response: Response<ProductDetailsResponse>?, errorBody: ResponseBody?, retrofit: Retrofit?) {
                val jObjError = JSONObject(errorBody?.string())
                mView?.failureProductDetails("${jObjError.get("message")}")
            }
        })
    }




    override fun start() {
    }

    override fun stop() {
    }
}