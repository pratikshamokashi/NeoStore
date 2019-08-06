package com.example.neostoreapp.ui.orderdetails

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.base.BaseActivity
import com.example.neostoreapp.ui.mycartlisting.MyCartAdapter
import com.example.neostoreapp.ui.mycartlisting.MyCartResponse
import com.example.neostoreapp.ui.mycartlisting.MyCartViewModel
import com.example.neostoreapp.ui.mycartlisting.Product
import com.example.neostoreapp.ui.myorder.DataItem
import com.example.neostoreapp.ui.myorder.MyOrderAdapter
import com.example.neostoreapp.ui.myorder.MyOrderResponse
import kotlinx.android.synthetic.main.activity_my_cart.*
import kotlinx.android.synthetic.main.activity_my_oder_list.*
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.toolbar.*

class OrderDetailsActivity : BaseActivity() {
    override val layout = R.layout.activity_order_details
    private lateinit var sharedPreferences: SharedPreferences

    lateinit var viewModel: OrderDetailsViewModel
    private var myadapter: OrderDetailsAdapter? = null
    lateinit var list: List<OrderDetailsItem>
    override fun init() {
        var orderId=intent.extras.get("id").toString()
        txt_neostore1.setText("Order ID : "+orderId)
        menu_img.visibility = View.GONE
       //search_img.visibility = View.GONE
         Log.d("Tag", "init")

         viewModel = ViewModelProviders.of(this).get(OrderDetailsViewModel::class.java)
         sharedPreferences = getSharedPreferences("myPref", 0)
         viewModel.orderDetails(sharedPreferences.getString("access_token", null),orderId)
        ab_back_white.setOnClickListener {
            finish()
         }

       viewModel.orderDetails().observe(this, Observer<OrderDetailsResponse> {
           if (it != null) {
               Log.d("tag","sucess102: "+it)
               setAdapter(it)
               success(it)

           } else {
               //failure()
           }
       })
    }
    fun setAdapter(res: OrderDetailsResponse) {
        Log.d("tag","adpter")
        myadapter = OrderDetailsAdapter(this,res.data?.orderDetails)
        myorderDetail_recycler_view.layoutManager= androidx.recyclerview.widget.LinearLayoutManager(this)
        myorderDetail_recycler_view.adapter=myadapter
        myadapter!!.notifyDataSetChanged()
    }
    private fun success(res: OrderDetailsResponse)
    {
        tv_ordertotal1.setText("Rs:"+res.data?.cost.toString())
    }
}

