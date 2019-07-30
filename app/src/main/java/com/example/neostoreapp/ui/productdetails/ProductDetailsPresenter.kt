package com.example.neostoreapp.ui.productdetails

import android.content.Context
import android.util.Log
import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit

class ProductDetailsPresenter(productView:ProductDetailContract.ProductDetailsView,context: Context):ProductDetailContract.ProductDetailsPresenter {

    var mView:ProductDetailContract.ProductDetailsView?=null
    private var context:Context
  //  lateinit var myAdapter:ProductAdapter
    private var data:List<ProductImagesItemModel>? = null
    init {
        this.context=context
        this.mView=productView
        }

    override fun productDetails(product_id: String) {
        Log.i("Pratiksha", "HERE.......1")
        APIManager().productDetails(product_id, object :APICallback<ProductDetailsResponse>()
        {
            override fun onSucess(code: Int?, response: ProductDetailsResponse?) {
                Log.i("Pratiksha", "HERE.......2")
                Log.d("tag","onsucess........"+mView)
                mView?.sucessProductDetails(response)

            }

            override fun onFail(code: Int?, response: Response<ProductDetailsResponse>?, errorBody: ResponseBody?, retrofit: Retrofit?) {
                val jObjError = JSONObject(errorBody?.string())
                mView?.failureProductDetails("${jObjError.get("message")}")
            }
        })
    }

    override fun setRating(product_id: String, rating: String) {
        Log.d("tag","setRating1")
        APIManager().setRating(product_id, rating, object :APICallback<RatingResponse>(){
            override fun onSucess(code: Int?, response: RatingResponse?) {
                Log.d("tag","setRating2")
                if (response != null) {

                    mView?.sucessRating(response)
                }
            }

            override fun onFail(code: Int?, response: Response<RatingResponse>?, errorBody: ResponseBody?, retrofit: Retrofit?) {
                val jObjError = JSONObject(errorBody?.string())
                mView?.failureProductDetails("${jObjError.get("message")}")
            }
        })
    }

  override fun setQuantity(access_token:String,product_id:String,quantity:String){
      Log.d("tag","setQuantity1"+quantity)
      APIManager().setQuantity(access_token,product_id,quantity,object :APICallback<QuantityResponse>()
      {
          override fun onSucess(code: Int?, response: QuantityResponse?) {
              Log.d("tag","setQuantity2")
              if (response != null) {
                  mView?.sucessToSetQuantity(response)
              }
          }

          override fun onFail(code: Int?, response: Response<QuantityResponse>?,
                              errorBody: ResponseBody?, retrofit: Retrofit?) {
           Log.d("tag","failQ")
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