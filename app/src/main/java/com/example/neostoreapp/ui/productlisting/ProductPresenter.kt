package com.example.neostoreapp.ui.productlisting

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.example.neostoreapp.net.APICallback
import com.example.neostoreapp.net.APIManager
import com.example.neostoreapp.ui.productlisting.ProductContract.ProductView
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit

class ProductPresenter(productview: ProductContract.ProductView,context: Context) : ProductContract.Presenter {
    lateinit var myAdapter: MyAdapter
    private var data:List<Data1>? = null
    var mView: ProductView? = null
    private var context: Context


    init {
        this.mView = productview
        this.context=context
    }

    override fun productlisting(product_category_id: String, limit: String, page: String) {
        APIManager().productlist(product_category_id, limit, page, object : APICallback<ProductResponse>() {
            override fun onSucess(code: Int?, response: ProductResponse?) {
                mView?.sucessProduct(response)
            }

            override fun onFail(
                code: Int?,
                response: Response<ProductResponse>?,
                errorBody: ResponseBody?,
                retrofit: Retrofit?
            ) {
                // super.onFail(code, response, errorBody, retrofit)
                val jObjError = JSONObject(errorBody?.string())
                mView?.failureProduct("${jObjError.get("message")}")
            }
        }
        )
    }

    fun passDataToAdapter(data: List<Data1>?) {
        setDataToAdapter(data)
    }

    fun setDataToAdapter(data: List<Data1>?) {
        myAdapter.setToAdapter(data)
        myAdapter.notifyDataSetChanged()
    }

    fun setAdapter(mRecyclerView: RecyclerView) {
        myAdapter = MyAdapter(data,context)
        mRecyclerView.adapter = myAdapter
    }


    override fun start() {
    }

    override fun stop() {
    }

}