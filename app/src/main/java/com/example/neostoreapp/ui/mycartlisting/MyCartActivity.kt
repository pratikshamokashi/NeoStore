package com.example.neostoreapp.ui.mycartlisting

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.example.neostoreapp.R
import com.example.neostoreapp.ui.address.AddressDataActivity
import com.example.neostoreapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my_cart.*
import kotlinx.android.synthetic.main.mycart_row_layout.*
import kotlinx.android.synthetic.main.toolbar.*

class MyCartActivity : BaseActivity() {
    override val layout=R.layout.activity_my_cart

    private lateinit var sharedPreferences: SharedPreferences

    lateinit  var viewModel: MyCartViewModel
    private var myadapter: MyCartAdapter? = null
    lateinit var list: List<Product>
    override fun init() {
        txt_neostore1.setText("My Cart")
        menu_img.visibility = View.GONE
        search_img.visibility = View.GONE
        Log.d("Tag", "init")

        viewModel = ViewModelProviders.of(this).get(MyCartViewModel::class.java)
        sharedPreferences = getSharedPreferences("myPref", 0)
        viewModel.mycartList(sharedPreferences.getString("access_token", null))

        ab_back_white.setOnClickListener {
            finish()
        }

            viewModel.mycartList().observe(this, Observer<MyCartResponse> {
            if (it != null) {
                   setAdapter(it)
                   mycartSucess(it)

            } else {
                failure()
            }
        })

        btn_order_now.setOnClickListener{
            val intent=Intent(this, AddressDataActivity::class.java)
            startActivity(intent)
        }

    }
        fun setAdapter(res:MyCartResponse)
        {
            myadapter =MyCartAdapter(res.data,this)
            mycart_recycler_view.layoutManager= LinearLayoutManager(this)
            mycart_recycler_view.adapter=myadapter
            myadapter!!.notifyDataSetChanged()
        }

    private fun mycartSucess(response: MyCartResponse){
        tv_total.setText("Rs:"+response.total.toString())
    }
    private fun failure(){

    }

}
